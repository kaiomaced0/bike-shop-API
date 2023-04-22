package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.bike.Bike;
import br.glacks.repository.BikeRepository;
import br.glacks.service.BikeService;

public class BikeServiceImpl implements BikeService {

    
    @Inject
    BikeRepository repository;
    
    public List<Bike> getAll(){
        return repository.findAll().list();
        
    }

    public Bike getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Bike bike){
        repository.persist(bike);
        return Response.ok(bike).build();
    }

    @Transactional
    public Bike update(long id, Bike bike){
        Bike entity = repository.findById(id);
        entity.setNome(bike.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
