package br.glacks.service.impl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.model.ItemCompra;
import br.glacks.repository.ItemCompraRepository;
import br.glacks.service.ItemCompraService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemCompraServiceImpl implements ItemCompraService {

    @Inject
    ItemCompraRepository repository;
    
    @Override
    public List<ItemCompra> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public ItemCompra getId(long id){
        return repository.findById(id);
        
    }

    @Override
    @Transactional
    public Response insert(ItemCompra itemcompra){
        repository.persist(itemcompra);
        return Response.ok(itemcompra).build();
    }

    @Override
    @Transactional
    public ItemCompra update(long id, ItemCompra itemcompra){
        ItemCompra entity = repository.findById(id);
        entity.setNome(itemcompra.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        repository.deleteById(id);
        return Response.status(Status.OK).build();
    }

    
    
}
