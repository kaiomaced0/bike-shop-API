package br.glacks.service.impl;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.ProdutoAdminResponseDTO;
import br.glacks.model.Cor;
import br.glacks.model.EntityClass;
import br.glacks.repository.MarcaRepository;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.application.Result;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.form.ImageForm;
import br.glacks.model.Produto;
import br.glacks.repository.ProdutoRepository;
import br.glacks.service.FileService;
import br.glacks.service.ProdutoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    public static final Logger LOG = Logger.getLogger(ProdutoServiceImpl.class);

    @Inject
    ProdutoRepository repository;

    @Inject
    FileService fileService;

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    MarcaRepository marcaRepository;

    @Override
    public List<ProdutoResponseDTO> getAll() {

        try {
            LOG.info("Requisição Produto.getAll()");

            return repository.findAll()
                    .stream()
                    .sorted(Comparator.comparing(produto -> produto.getId()))
                    .map(produto -> new ProdutoResponseDTO(produto))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.getAll()");
            return null;
        }

    }

    @Override
    public List<ProdutoAdminResponseDTO> getAllAdmin() {

        try {
            LOG.info("Requisição Produto.getAll()");

            return repository.findAll()
                    .stream()
                    .sorted(Comparator.comparing(EntityClass::getId))
                    .map(ProdutoAdminResponseDTO::new)
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
    public List<ProdutoResponseDTO> getNome(String nome) {
        try {
            LOG.info("Requisição Produto.getNome()");

            return repository.findByNome(nome)
                    .stream()
                    .map(produto -> new ProdutoResponseDTO(produto))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.getNome()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(ProdutoDTO produto) {
        try {
            LOG.info("Requisição Produto.insert()");
            Produto p = ProdutoDTO.criaProduto(produto);
            p.setMarca(marcaRepository.findById(produto.idMarca()));
            p.setCor(Cor.valueOf(produto.idCor().intValue()));
            repository.persist(p);
            return Response.ok(produto).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.insert()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    @Transactional
    public Response update(long id, ProdutoDTO produto) {
        try {
            LOG.info("Requisição Produto.update()");

            Produto entity = repository.findById(id);
            if(produto.nome() != null)
                entity.setNome(produto.nome());
            if(produto.idMarca() != null)
                entity.setMarca(marcaRepository.findById(produto.idMarca()));
            if(produto.nomeLongo() != null)
                entity.setNomeLongo(produto.nomeLongo());
            if(produto.precoCusto() != null)
                entity.setValorCompra(produto.precoCusto());
            if(produto.precoVenda() != null)
                entity.setPreco(produto.precoVenda());
            return Response.ok(new ProdutoResponseDTO(entity)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Produto.update()");
            return Response.status(400).build();
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

    @Override
    @Transactional
    public Response salvarImagem(@MultipartForm ImageForm form, Long produtoId) {
        String nomeImagem = "";

        try {
            nomeImagem = fileService.salvarImagemProduto(form.getImagem(), form.getNome());
            // obtendo o login a partir do token
            Produto p = repository.findById(produtoId);
            p.getImg().add(nomeImagem);

            LOG.info("Requisição Produto.salvarImagem()");

            return Response.ok(new ProdutoResponseDTO(p)).build();
        } catch (IOException e) {
            Result result = new Result(e.getMessage());

            LOG.error("Erro ao rodar Requisição Produto.salvarImagem()");

            return Response.status(Status.CONFLICT).entity(result).build();
        }

    }
}
