package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Cartao;
import br.glacks.repository.CartaoRepository;

public class CartaoServiceImpl implements CartaoService {

    @Inject
    CartaoRepository repository;
    
    public List<Cartao> getAll(){
        return repository.findAll().list();
        
    }

    public Cartao getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Cartao cartao){
        repository.persist(cartao);
        return Response.ok(cartao).build();
    }

    @Transactional
    public Cartao update(long id, Cartao cartao){
        Cartao entity = repository.findById(id);
        entity.setNome(cartao.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
