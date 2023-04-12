package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Categoria;
import br.glacks.repository.CategoriaRepository;

public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    CategoriaRepository repository;
    
    public List<Categoria> getAll(){
        return repository.findAll().list();
        
    }

    public Categoria getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Categoria categoria){
        repository.persist(categoria);
        return Response.ok(categoria).build();
    }

    @Transactional
    public Categoria update(long id, Categoria categoria){
        Categoria entity = repository.findById(id);
        entity.setNome(categoria.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
