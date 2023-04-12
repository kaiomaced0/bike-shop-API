package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Cep;
import br.glacks.repository.CepRepository;

public class CepServiceImpl implements CepService {

    @Inject
    CepRepository repository;
    
    public List<Cep> getAll(){
        return repository.findAll().list();
        
    }

    public Cep getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Cep cep){
        repository.persist(cep);
        return Response.ok(cep).build();
    }

    @Transactional
    public Cep update(long id, Cep cep){
        Cep entity = repository.findById(id);
        entity.setNome(cep.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
