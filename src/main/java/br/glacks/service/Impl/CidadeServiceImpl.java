package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.locais.Cidade;
import br.glacks.repository.CidadeRepository;
import br.glacks.service.CidadeService;

public class CidadeServiceImpl implements CidadeService {

    @Inject
    CidadeRepository repository;
    
    public List<Cidade> getAll(){
        return repository.findAll().list();
        
    }

    public Cidade getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Cidade cidade){
        repository.persist(cidade);
        return Response.ok(cidade).build();
    }

    @Transactional
    public Cidade update(long id, Cidade cidade){
        Cidade entity = repository.findById(id);
        entity.setNome(cidade.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
