package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.ItemCompraDTO;
import br.glacks.model.*;
import br.glacks.model.pagamento.FormaPagamento;
import br.glacks.repository.CupomRepository;
import br.glacks.repository.EnderecoRepository;
import br.glacks.repository.ItemCompraRepository;
import br.glacks.service.CupomService;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.CompraDTO;
import br.glacks.dto.CompraResponseDTO;
import br.glacks.repository.CompraRepository;
import br.glacks.service.CompraService;
import br.glacks.service.UsuarioLogadoService;
import br.glacks.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraServiceImpl implements CompraService {

    public static final Logger LOG = Logger.getLogger(CompraServiceImpl.class);

    @Inject
    CompraRepository repository;

    @Inject
    UsuarioLogadoService usuarioLogado;

    @Inject
    UsuarioService usuarioService;

    @Inject
    ItemCompraRepository itemCompraRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    CupomRepository cupomRepository;

    @Inject
    CupomService cupomService;

    @Override
    public List<CompraResponseDTO> getAll() {
        try {
            LOG.info("Requisição Compra.getAll()");
            return repository.findAll().stream().map(CompraResponseDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.getAll()");
            return null;
        }

    }

    @Override
    public List<CompraResponseDTO> getAllOn() {
        try {
            LOG.info("Requisição Compra.getAll()");
            Usuario user = usuarioService.getId(usuarioLogado.getPerfilUsuarioLogado().id());

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
            Compra c = CompraDTO.criaCompra(compra);
            c.setValorTotal(0.0);
            c.setListaItemCompra(compra.listaItemCompraDTO().stream().map(
                    itemCompra -> {
                        ItemCompra i = ItemCompraDTO.criaItemCompra(itemCompra);
                        itemCompraRepository.persist(i);
                        c.setValorTotal(c.getValorTotal() + i.getPreco());
                        return i;
                    }).collect(Collectors.toList()));
            Endereco e = enderecoRepository.findById(compra.idEndereco());
            Cupom cupom = cupomService.isActive(compra.idCupom());
            if(compra.idCupom() != null){
                if(cupom != null){
                    c.setValorTotal(c.getValorTotal() * ( 1 - (cupom.getValorDesconto() / 100)));
                }
            }
            if(e == null){
                throw new Exception("Endereco nulo!");
            }
            c.setEnderecoEntrega(e);


            repository.persist(c);

            LOG.info("Requisição Compra.insert()");

            return Response.ok(new CompraResponseDTO(c)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.insert()");
            return Response.status(Status.NO_CONTENT).build();
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
