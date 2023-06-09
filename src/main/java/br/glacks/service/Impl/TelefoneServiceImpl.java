package br.glacks.service.impl;

import java.util.List;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.model.Telefone;
import br.glacks.repository.TelefoneRepository;
import br.glacks.service.TelefoneService;
import br.glacks.service.UsuarioLogadoService;
import br.glacks.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {

    public static final Logger LOG = Logger.getLogger(TelefoneServiceImpl.class);

    @Inject
    TelefoneRepository repository;

    @Inject
    UsuarioLogadoService usuarioLogadoService;

    @Inject
    UsuarioService usuarioService;

    @Override
    public List<Telefone> getAll() {

        try {
            LOG.info("Requisição Telefone.getAll()");

            return repository.findAll().list();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getAll()");
            return null;
        }

    }

    @Override
    public Telefone getId(long id) {
        try {
            LOG.info("Requisição Telefone.getAll()");

            return repository.findById(id);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getAll()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(Telefone telefone) {
        try {
            LOG.info("Requisição Telefone.getAll()");

            repository.persist(telefone);
            return Response.ok(telefone).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getAll()");
            return null;
        }

    }

    @Override
    @Transactional
    public Telefone update(long id, Telefone telefone) {
        try {
            LOG.info("Requisição Telefone.getAll()");

            Telefone entity = repository.findById(id);
            entity.setNome(telefone.getNome());
            return entity;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getAll()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Telefone.getAll()");

            Telefone entity = repository.findById(id);
            entity.setAtivo(false);
    
            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getAll()");
            return null;
        }

    }

}
