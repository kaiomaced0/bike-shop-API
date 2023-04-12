package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Endereco;
import br.glacks.repository.EnderecoRepository;

public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    EnderecoRepository repository;
    
    public List<Endereco> getAll(){
        return repository.findAll().list();
        
    }

    public Endereco getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Endereco endereco){
        repository.persist(endereco);
        return Response.ok(endereco).build();
    }

    @Transactional
    public Endereco update(long id, Endereco endereco){
        Endereco entity = repository.findById(id);
        entity.setNome(endereco.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
