package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Pedido;
import br.glacks.repository.PedidoRepository;

public class PedidoServiceImpl implements PedidoService {

    @Inject
    PedidoRepository repository;
    
    public List<Pedido> getAll(){
        return repository.findAll().list();
        
    }

    public Pedido getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Pedido pedido){
        repository.persist(pedido);
        return Response.ok(pedido).build();
    }

    @Transactional
    public Pedido update(long id, Pedido pedido){
        Pedido entity = repository.findById(id);
        entity.setNome(pedido.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
