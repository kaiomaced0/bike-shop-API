package br.glacks.service.impl;

import java.util.List;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.model.Cupom;
import br.glacks.repository.CupomRepository;
import br.glacks.service.CupomService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

    public static final Logger LOG = Logger.getLogger(AvaliacaoServiceImpl.class);

    @Inject
    CupomRepository repository;
    
    @Override
    public List<Cupom> getAll(){
        try {
            LOG.info("Requisição Cupom.getAll()");
            return repository.findAll().list();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getAll()");
            return null;
        }
        
    }

    @Override
    public Cupom getId(long id){
        try {
            LOG.info("Requisição Cupom.getId()");
            return repository.findById(id);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getId()");
            return null;
        }
        
        
    }

    @Override
    public List<Cupom> getNome(String nome){
        try {
            LOG.info("Requisição Cupom.getNome()");
            return repository.findByNome(nome);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getNome()");
            return null;
        }
        
        
    }

    @Override
    @Transactional
    public Response insert(Cupom cupom){
        try {
            LOG.info("Requisição Cupom.insert()");
            repository.persist(cupom);
            return Response.ok(cupom).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.insert()");
            return null;
        }
        
    }

    @Override
    @Transactional
    public Cupom update(long id, Cupom cupom){
        try {
            LOG.info("Requisição Cupom.update()");
            Cupom entity = repository.findById(id);
            entity.setNome(cupom.getNome());
            return entity;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.update()");
            return null;
        }
        
    }
    
   @Override
   @Transactional
    public Response delete(Long id) { 
        try {
            LOG.info("Requisição Cupom.delete()");
            Cupom entity = repository.findById(id);
            entity.setAtivo(false);
                
            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.delete()");
            return null;
        }
        
    }

    
    
}
