package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;
import br.glacks.repository.EnderecoRepository;
import br.glacks.service.EnderecoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    public static final Logger LOG = Logger.getLogger(EnderecoServiceImpl.class);

    @Inject
    EnderecoRepository repository;

    @Override
    public List<EnderecoResponseDTO> getAll() {
        try {
            LOG.info("Requisição endereco.getAll()");
            return repository.findAll()
                    .stream()
                    .map(EnderecoResponseDTO::new)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.getAll()");
            return null;
        }

    }

    @Override
    public EnderecoResponseDTO getId(long id) {
        try {
            LOG.info("Requisição endereco.getId()");

            return new EnderecoResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.getId()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(Endereco endereco) {
        try {
            LOG.info("Requisição endereco.insert()");

            repository.persist(endereco);
            return Response.ok(endereco).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.insert()");
            return null;
        }

    }

    @Override
    @Transactional
    public Endereco update(long id, Endereco endereco) {
        try {
            LOG.info("Requisição endereco.update()");

            Endereco entity = repository.findById(id);
            entity.setNome(endereco.getNome());
            return entity;

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.update()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição endereco.delete()");

            Endereco entity = repository.findById(id);
            entity.setAtivo(false);
    
            return Response.status(Status.OK).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.delete()");
            return null;
        }

    }

}
