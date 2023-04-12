package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Estoque;
import br.glacks.repository.EstoqueRepository;

public class EstoqueServiceImpl implements EstoqueService {

    @Inject
    EstoqueRepository repository;
    
    public List<Estoque> getAll(){
        return repository.findAll().list();
        
    }

    public Estoque getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Estoque estoque){
        repository.persist(estoque);
        return Response.ok(estoque).build();
    }

    @Transactional
    public Estoque update(long id, Estoque estoque){
        Estoque entity = repository.findById(id);
        entity.setNome(estoque.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
