package br.glacks.service.impl;

import java.util.List;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.model.locais.Estado;
import br.glacks.repository.EstadoRepository;
import br.glacks.service.EstadoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    public static final Logger LOG = Logger.getLogger(EstadoServiceImpl.class);

    @Inject
    EstadoRepository repository;
    
    @Override
    public List<Estado> getAll(){
        
        try {
            LOG.info("Requisição Estado.getAll()");
            return repository.findAll().list();
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Estado.getAll()");
            return null;
        }
        
        
    }

    @Override
    public Estado getId(long id){
        try {
            LOG.info("Requisição Estado.getId()");
            return repository.findById(id);
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Estado.getId()");
            return null;
        }
        
    }

    @Override
    @Transactional
    public Response insert(Estado estado){
        try {
            LOG.info("Requisição Estado.insert()");
            repository.persist(estado);
            return Response.ok(estado).build();
                    
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Estado.insert()");
            return null;
        }
    }

    @Override
    @Transactional
    public Estado update(long id, Estado estado){
        try {
            LOG.info("Requisição Estado.update()");
            Estado entity = repository.findById(id);
            entity.setNome(estado.getNome());
            return entity;
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Estado.update()");
            return null;
        }
    }
    
   @Override
   @Transactional
   public Response delete(Long id) {
    try {
        LOG.info("Requisição Estado.delete()");
        Estado entity = repository.findById(id);
        entity.setAtivo(false);
            
        return Response.status(Status.OK).build();
        
    } catch (Exception e) {
        LOG.error("Erro ao rodar Requisição Estado.delete()");
        return null;
    }
    }

    
    
}
