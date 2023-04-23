package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Telefone;
import br.glacks.repository.TelefoneRepository;
import br.glacks.service.TelefoneService;

public class TelefoneServiceImpl implements TelefoneService {

    @Inject
    TelefoneRepository repository;
    
    public List<Telefone> getAll(){
        return repository.findAll().list();
        
    }

    public Telefone getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Telefone telefone){
        repository.persist(telefone);
        return Response.ok(telefone).build();
    }

    @Transactional
    public Telefone update(long id, Telefone telefone){
        Telefone entity = repository.findById(id);
        entity.setNome(telefone.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
