package br.glacks.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import br.glacks.dto.ItemCompraDTO;
import br.glacks.dto.ValidaCompraResponseDTO;
import br.glacks.model.*;
import br.glacks.repository.*;
import br.glacks.service.CupomService;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.CompraDTO;
import br.glacks.dto.CompraResponseDTO;
import br.glacks.service.CompraService;
import br.glacks.service.UsuarioLogadoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraServiceImpl implements CompraService {

    public static final Logger LOG = Logger.getLogger(CompraServiceImpl.class);

    @Inject
    CompraRepository repository;

    @Inject
    UsuarioLogadoService usuarioLogado;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    ItemCompraRepository itemCompraRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    CupomRepository cupomRepository;

    @Inject
    CupomService cupomService;

    @Inject
    ProdutoRepository produtoRepository;

    @Override
    public Response getAll(int page, int pageSize) {
        try {
            LOG.info("Requisição Compra.getAll()");
            return Response.ok(repository.findAll().page(page, pageSize).stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId).reversed()).map(CompraResponseDTO::new)
                    .collect(Collectors.toList())).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.getAll()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    public long count() {
        try {
            return repository.findAll()
                    .stream().filter(EntityClass::getAtivo)
                    .toList().size();

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Response getValorTeste(List<ItemCompraDTO> listaItemCompra) {
        try{
            if(listaItemCompra.isEmpty()){
                throw new Exception();
            }
            AtomicReference<Double> total = new AtomicReference<>(0.0);
            listaItemCompra.forEach(i -> {
                Produto p = produtoRepository.findById(i.produtoId());
                total.set(total.get() + (p.getPreco() * i.quantidade()));
            });
            return Response.ok(total.get()).build();

        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();

        }
    }

    @Override
    public List<CompraResponseDTO> getAllOn() {
        try {
            LOG.info("Requisição Compra.getAll()");
            Usuario user = usuarioRepository.findById(usuarioLogado.getPerfilUsuarioLogado().id());

            return user.getCompras().stream().map(CompraResponseDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.getAll()");
            return null;
        }

    }

    @Override
    public CompraResponseDTO getId(long id) {
        try {
            LOG.info("Requisição Compra.getId()");
            return new CompraResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.getId()");
            return null;
        }

    }

    @Override
    public Response mudarStatusPedido(long id, int idStatusPedido) {

        Compra entity = repository.findById(id);
        try {
            entity.setStatusPedido(StatusPedido.valueOf(idStatusPedido));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.mudarStatusPedido()");
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
        LOG.info("Requisição Compra.mudarStatusPedido()");
        return Response.status(Status.OK).build();

    }

    @Override
    @Transactional
    public Response insert(CompraDTO compra) {

        try {
            Usuario user = usuarioRepository.findById(usuarioLogado.getPerfilUsuarioLogado().id());

            Compra c = CompraDTO.criaCompra(compra);
            c.setValorTotal(0.0);
            c.setListaItemCompra(new ArrayList<>());
            if(compra.idCupom() != null){
                Cupom cupom = cupomService.isActive(compra.idCupom());
                if(cupom.getQuantidade() > 0) {
                    compra.listaItemCompra().stream().forEach(
                            itemCompra -> {
                                ItemCompra i = ItemCompraDTO.criaItemCompra(itemCompra);
                                Produto p = produtoRepository.findById(itemCompra.produtoId());
                                i.setProduto(p);
                                i.setPreco(p.getPreco());
                                i.setQuantidade(itemCompra.quantidade());
                                itemCompraRepository.persist(i);
                                c.getListaItemCompra().add(i);

                                if (cupom.getProdutos().contains(p)) {
                                    c.setValorTotal(c.getValorTotal() + ((p.getPreco() * itemCompra.quantidade()) * (1 - (cupom.getValorDesconto() / 100))));
                                } else {
                                    c.setValorTotal(c.getValorTotal() + (p.getPreco() * itemCompra.quantidade()));
                                }
                            });
                }
                else{
                    compra.listaItemCompra().stream().forEach(
                            itemCompra -> {
                                ItemCompra i = ItemCompraDTO.criaItemCompra(itemCompra);

                                Produto p = produtoRepository.findById(itemCompra.produtoId());
                                i.setProduto(p);
                                i.setPreco(p.getPreco());
                                i.setQuantidade(itemCompra.quantidade());
                                itemCompraRepository.persist(i);
                                c.getListaItemCompra().add(i);

                                c.setValorTotal(c.getValorTotal() + (p.getPreco() * itemCompra.quantidade()));

                            });

                }
            }else{
                compra.listaItemCompra().stream().forEach(
                        itemCompra -> {
                            ItemCompra i = ItemCompraDTO.criaItemCompra(itemCompra);
                            Produto p = produtoRepository.findById(itemCompra.produtoId());
                            i.setProduto(p);
                            i.setPreco(p.getPreco());
                            i.setQuantidade(itemCompra.quantidade());
                            itemCompraRepository.persist(i);
                            c.getListaItemCompra().add(i);

                            c.setValorTotal(c.getValorTotal() + (p.getPreco() * itemCompra.quantidade()));

                        });
            }

            Endereco e = enderecoRepository.findById(compra.idEndereco());
            c.setEnderecoEntrega(e);
            c.setUsuario(user);
            c.setDataPrevista(LocalDate.now().plusDays(25).toString());
            if(user.getCompras().isEmpty()){
                user.setCompras(new ArrayList<>());
            }
            c.setPago(false);

            repository.persist(c);
            user.getCompras().add(c);
            LOG.info("Requisição Compra.insert()");

            return Response.ok(new CompraResponseDTO(c)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.insert()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    public ValidaCompraResponseDTO verificarCompra(CompraDTO compra) {
        try {
            Compra c = CompraDTO.criaCompra(compra);
            c.setValorTotal(0.0);
            if(compra.idCupom() != null){
                Cupom cupom = cupomService.isActive(compra.idCupom());
                if(cupom.getQuantidade() > 0) {
                    compra.listaItemCompra().stream().forEach(
                            itemCompra -> {
                                Produto p = produtoRepository.findById(itemCompra.produtoId());

                                if (cupom.getProdutos().contains(p)) {
                                    c.setValorTotal(c.getValorTotal() + ((p.getPreco() * itemCompra.quantidade()) * (1 - (cupom.getValorDesconto() / 100))));
                                } else {
                                    c.setValorTotal(c.getValorTotal() + (p.getPreco() * itemCompra.quantidade()));
                                }
                            });
                }
                else{
                    compra.listaItemCompra().stream().forEach(
                        itemCompra -> {
                            Produto p = produtoRepository.findById(itemCompra.produtoId());
                            c.setValorTotal(c.getValorTotal() + (p.getPreco() * itemCompra.quantidade()));

                        });

                }
            }else{
                compra.listaItemCompra().stream().forEach(
                        itemCompra -> {
                            Produto p = produtoRepository.findById(itemCompra.produtoId());
                                c.setValorTotal(c.getValorTotal() + (p.getPreco() * itemCompra.quantidade()));

                        });
            }

            Endereco e = enderecoRepository.findById(compra.idEndereco());
            if(e == null){
                throw new Exception("Endereco nulo!");
            }

            LOG.info("Requisição Compra.verificarCompra() " + c.getValorTotal());

            return new ValidaCompraResponseDTO(c.getValorTotal());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.verificarCompra()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Compra.delete()");
            Compra entity = repository.findById(id);
            entity.setAtivo(false);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.delete()");
            return null;
        }
    }

    @Override
    @Transactional
    public Response realizarPagamentoCompra(long id, String tokenPagamento) {

        Compra entity = repository.findById(id);
        if (entity != null) {
            entity.setStatusPedido(StatusPedido.PREPARANDO);
            entity.setPago(true);
            entity.setToken(tokenPagamento);
            LOG.info("Requisição Compra.realizarPagamentoCompra()");
            return Response.status(Status.OK).build();
        } else {

            LOG.error("Erro ao rodar Requisição Compra.realizarPagamentoCompra()");
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
    }

}
