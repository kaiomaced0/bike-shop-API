package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.bike.Bike;
import br.glacks.repository.BikeRepository;
import br.glacks.service.BikeService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BikeServiceImpl implements BikeService {

    
    @Inject
    BikeRepository repository;
    
    @Override
    public List<Bike> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Bike getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<Bike> getNome(String nome){
        return repository.findByNome(nome);
        
    }

    @Override
    @Transactional
    public Response insert(Bike bike){
        repository.persist(bike);
        return Response.ok(bike).build();
    }

    @Override
    @Transactional
    public Bike update(long id, Bike bike){
        Bike entity = repository.findById(id);
        entity.setNome(bike.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
