package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.Produto;
import br.glacks.repository.ProdutoRepository;
import br.glacks.service.ProdutoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    public static final Logger LOG = Logger.getLogger(ProdutoServiceImpl.class);

    @Inject
    ProdutoRepository repository;

    @Override
    public List<ProdutoResponseDTO> getAll() {

        try {
            LOG.info("Requisição Produto.getAll()");

            return repository.findAll()
                    .stream()
                    .map(produto -> new ProdutoResponseDTO(produto))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.getAll()");
            return null;
        }

    }

    @Override
    public Produto getId(long id) {
        try {
            LOG.info("Requisição Produto.getId()");

            return repository.findById(id);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.getId()");
            return null;
        }

    }

    @Override
    public List<Produto> getNome(String nome) {
        try {
            LOG.info("Requisição Produto.getNome()");

            return repository.findByNome(nome);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.getNome()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(Produto produto) {
        try {
            LOG.info("Requisição Produto.insert()");

            repository.persist(produto);
            return Response.ok(produto).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.insert()");
            return null;
        }

    }

    @Override
    @Transactional
    public Produto update(long id, Produto produto) {
        try {
            LOG.info("Requisição Produto.update()");

            Produto entity = repository.findById(id);
            entity.setNome(produto.getNome());
            return entity;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.update()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Produto.delete()");

            Produto entity = repository.findById(id);
            entity.setAtivo(false);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.delete()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response retiraEstoque(Long id, int quantidade) {
        try {

            Produto entity = repository.findById(id);
            Integer quantidadeTeste = entity.getEstoque() - quantidade;
            if (quantidadeTeste < 0) {
                return Response.status(Status.CONFLICT).build();
            } else if (quantidadeTeste >= 0) {
                entity.setEstoque(entity.getEstoque() - quantidade);
            } else {
                return Response.status(Status.CONFLICT).build();
            }

            LOG.info("Requisição Produto.retiraEstoque()");

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.retiraEstoque()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response adicionaEstoque(Long id, int quantidade) {
        try {
            Produto entity = repository.findById(id);
            if (quantidade <= 0) {
                return Response.status(Status.CONFLICT).build();
            }
            try {
                entity.setEstoque(entity.getEstoque() + quantidade);
            } catch (Exception e) {
                return Response.status(Status.CONFLICT).build();
            }

            LOG.info("Requisição Produto.adicionaEstoque()");

            return Response.status(Status.OK).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.adicionaEstoque()");
            return null;
        }

    }

}
