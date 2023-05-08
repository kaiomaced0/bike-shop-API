package br.glacks.service.Impl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import br.glacks.model.Compra;
import br.glacks.repository.CompraRepository;
import br.glacks.service.CompraService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraServiceImpl implements CompraService {

    @Inject
    CompraRepository repository;
    
    @Override
    public List<Compra> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Compra getId(long id){
        return repository.findById(id);
        
    }

    @Override
    @Transactional
    public Response insert(Compra compra){
        repository.persist(compra);
        return Response.ok(compra).build();
    }

    @Override
    @Transactional
    public Compra update(long id, Compra compra){
        Compra entity = repository.findById(id);
        entity.setNome(compra.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
