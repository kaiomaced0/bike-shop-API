package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Produto;
import br.glacks.repository.ProdutoRepository;
import br.glacks.service.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;
    
    public List<Produto> getAll(){
        return repository.findAll().list();
        
    }

    public Produto getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Produto produto){
        repository.persist(produto);
        return Response.ok(produto).build();
    }

    @Transactional
    public Produto update(long id, Produto produto){
        Produto entity = repository.findById(id);
        entity.setNome(produto.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
