package br.glacks.service.Impl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.model.Produto;
import br.glacks.repository.ProdutoRepository;
import br.glacks.service.ProdutoService;
import jakarta.enterprise.context.ApplicationScoped;

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
        repository.deleteById(id);
        return Response.status(Status.OK).build();
    }

    
    
}
