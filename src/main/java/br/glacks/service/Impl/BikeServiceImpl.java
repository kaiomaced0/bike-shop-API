package br.glacks.service.impl;

import java.util.List;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.model.bike.Bike;
import br.glacks.repository.BikeRepository;
import br.glacks.service.BikeService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BikeServiceImpl implements BikeService {

    public static final Logger LOG = Logger.getLogger(BikeServiceImpl.class);

    
    @Inject
    BikeRepository repository;
    
    @Override
    public List<Bike> getAll(){
        try {
            LOG.info("Requisição Bike.delete()");
            return repository.findAll().list();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.getAll()");
            return null;
        }
        
    }

    @Override
    public Bike getId(long id){
        try {
            LOG.info("Requisição Bike.getId()");
            return repository.findById(id);
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.getId()");
            return null;
            // TODO: handle exception
        }
        
    }

    @Override
    public List<Bike> getNome(String nome){
        try {
            LOG.info("Requisição Bike.getId()");
            return repository.findByNome(nome);
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.getNome()");
            return null;

            // TODO: handle exception
        }
        
    }

    @Override
    @Transactional
    public Response insert(Bike bike){
        try {
            LOG.info("Requisição Bike.insert()");
            repository.persist(bike);
            return Response.ok(bike).build();
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.insert()");
            return null;
            // TODO: handle exception
        }
    }

    @Override
    @Transactional
    public Bike update(long id, Bike bike){
        try {
            LOG.info("Requisição Bike.update()");
            Bike entity = repository.findById(id);
            entity.setNome(bike.getNome());
            return entity;
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.update()");
            return null;
        }
        
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        try {
            Bike entity = repository.findById(id);
            entity.setAtivo(false);
            
            LOG.info("Requisição Bike.delete()");
            return Response.status(Status.OK).build();
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Bike.delete()");
            return Response.status(Status.NO_CONTENT).build();
            // TODO: handle exception
        }
        
    }
    
}
