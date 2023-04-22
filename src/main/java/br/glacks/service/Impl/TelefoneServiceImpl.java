package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Telefone;
import br.glacks.repository.AvaliacaoRepository;
import br.glacks.service.AvaliacaoService;

public class TelefoneServiceImpl implements AvaliacaoService {

    @Inject
    AvaliacaoRepository repository;
    
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
