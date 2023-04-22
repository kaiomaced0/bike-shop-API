package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.ItemCompra;
import br.glacks.repository.ItemCompraRepository;
import br.glacks.service.ItemCompraService;

public class ItemCompraServiceImpl implements ItemCompraService {

    @Inject
    ItemCompraRepository repository;
    
    public List<ItemCompra> getAll(){
        return repository.findAll().list();
        
    }

    public ItemCompra getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(ItemCompra itemcompra){
        repository.persist(itemcompra);
        return Response.ok(itemcompra).build();
    }

    @Transactional
    public ItemCompra update(long id, ItemCompra itemcompra){
        ItemCompra entity = repository.findById(id);
        entity.setNome(itemcompra.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
