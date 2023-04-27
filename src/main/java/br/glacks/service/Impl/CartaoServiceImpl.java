package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.pagamento.Cartao;
import br.glacks.repository.CartaoRepository;
import br.glacks.service.CartaoService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartaoServiceImpl implements CartaoService {

    @Inject
    CartaoRepository repository;
    
    @Override
    public List<Cartao> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Cartao getId(long id){
        return repository.findById(id);
        
    }

    @Override
    @Transactional
    public Response insert(Cartao cartao){
        repository.persist(cartao);
        return Response.ok(cartao).build();
    }

    @Override
    @Transactional
    public Cartao update(long id, Cartao cartao){
        Cartao entity = repository.findById(id);
        entity.setNome(cartao.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
