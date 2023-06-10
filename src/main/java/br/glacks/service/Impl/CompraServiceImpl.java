package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.CompraResponseDTO;
import br.glacks.model.Compra;
import br.glacks.model.ItemCompra;
import br.glacks.model.StatusPedido;
import br.glacks.model.Usuario;
import br.glacks.repository.CompraRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.CompraService;
import br.glacks.service.ProdutoService;
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
    ProdutoService produtoService;

    @Override
    public List<CompraResponseDTO> getAll() {
        try {
            LOG.info("Requisição Compra.getAll()");
            return repository.findAll().stream().map(compra -> new CompraResponseDTO(compra))
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
            Usuario user = usuarioRepository.findById(usuarioLogado.getPerfilUsuarioLogado().id());
            return user.getCompras().stream().map(compra -> new CompraResponseDTO(compra))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.getAll()");
            return null;
        }

    }

    @Override
    public Compra getId(long id) {
        try {
            LOG.info("Requisição Compra.getId()");
            return repository.findById(id);
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
    public Response insert(Compra compra) {
        if (compra != null) {

            Usuario entity = usuarioRepository.findByLogin(
                    usuarioLogado.getPerfilUsuarioLogado().login());
            compra.setUsuario(entity);
            compra.setStatusPedido(StatusPedido.PREPARANDO);

            for (ItemCompra item : compra.getListaItemCompra()) {
                try {
                    produtoService.retiraEstoque(item.getProduto().getId(), item.getQuantidade());
                } catch (Exception e) {
                    LOG.error("Erro ao rodar Requisição Compra.insert()");
                    return Response.status(Status.NO_CONTENT).build();
                }
            }
            repository.persist(compra);
            LOG.info("Requisição Compra.insert()");
            return Response.ok(compra).build();
        }
        return Response.status(Status.NO_CONTENT).build();

    }

    @Override
    @Transactional
    public Compra update(long id, Compra compra) {
        try {
            LOG.info("Requisição Compra.update()");
            Compra entity = repository.findById(id);
            entity.setNome(compra.getNome());
            return entity;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Compra.update()");
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

        Compra entity = getId(id);
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
