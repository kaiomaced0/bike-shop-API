package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Compra;
import br.glacks.repository.CompraRepository;

public class CompraServiceImpl implements CompraService {

    @Inject
    CompraRepository repository;
    
    public List<Compra> getAll(){
        return repository.findAll().list();
        
    }

    public Compra getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Compra compra){
        repository.persist(compra);
        return Response.ok(compra).build();
    }

    @Transactional
    public Compra update(long id, Compra compra){
        Compra entity = repository.findById(id);
        entity.setNome(compra.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
