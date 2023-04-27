package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Produto;
import br.glacks.repository.ProdutoRepository;
import br.glacks.service.ProdutoService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;
    
    @Override
    public List<Produto> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Produto getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<Produto> getNome(String nome){
        return repository.findByNome(nome);
        
    }

    @Override
    @Transactional
    public Response insert(Produto produto){
        repository.persist(produto);
        return Response.ok(produto).build();
    }

    @Override
    @Transactional
    public Produto update(long id, Produto produto){
        Produto entity = repository.findById(id);
        entity.setNome(produto.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
