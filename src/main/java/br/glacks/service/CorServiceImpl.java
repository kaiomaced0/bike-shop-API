package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Cor;
import br.glacks.repository.CorRepository;

public class CorServiceImpl implements CorService {

    @Inject
    CorRepository repository;
    
    public List<Cor> getAll(){
        return repository.findAll().list();
        
    }

    public Cor getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Cor cor){
        repository.persist(cor);
        return Response.ok(cor).build();
    }

    @Transactional
    public Cor update(long id, Cor cor){
        Cor entity = repository.findById(id);
        entity.setNome(cor.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
