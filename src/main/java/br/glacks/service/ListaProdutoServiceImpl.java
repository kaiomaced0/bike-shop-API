package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.ListaProduto;
import br.glacks.repository.ListaProdutoRepository;

public class ListaProdutoServiceImpl implements ListaProdutoService {

    @Inject
    ListaProdutoRepository repository;
    
    public List<ListaProduto> getAll(){
        return repository.findAll().list();
        
    }

    public ListaProduto getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(ListaProduto listaproduto){
        repository.persist(listaproduto);
        return Response.ok(listaproduto).build();
    }

    @Transactional
    public ListaProduto update(long id, ListaProduto listaproduto){
        ListaProduto entity = repository.findById(id);
        entity.setNome(listaproduto.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
