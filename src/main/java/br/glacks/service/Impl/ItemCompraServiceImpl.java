package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.glacks.model.ItemCompra;
import br.glacks.repository.ItemCompraRepository;
import br.glacks.service.ItemCompraService;
import javax.enterprise.context.ApplicationScoped;

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
