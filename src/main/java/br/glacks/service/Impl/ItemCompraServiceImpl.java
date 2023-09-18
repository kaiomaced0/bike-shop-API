package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.ItemCompraResponseDTO;
import org.jboss.logging.Logger;

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

    public static final Logger LOG = Logger.getLogger(ItemCompraServiceImpl.class);

    @Inject
    ItemCompraRepository repository;
    
    @Override
    public List<ItemCompraResponseDTO> getAll(){
        
        try {
            LOG.info("Requisição ItemCompra.getAll()");
            return repository.findAll().stream().map(ItemCompraResponseDTO::new).collect(Collectors.toList());
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição ItemCompra.getAll()");
            return null;
        }
        
    }

    @Override
    public ItemCompraResponseDTO getId(long id){
        
        try {
            LOG.info("Requisição ItemCompra.getId()");
            return new ItemCompraResponseDTO(repository.findById(id));
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição ItemCompra.getId()");
            return null;
        }
        
        
    }

    @Override
    @Transactional
    public Response insert(ItemCompra itemcompra){
        
        try {
            LOG.info("Requisição ItemCompra.insert()");
        
            repository.persist(itemcompra);
            return Response.ok(itemcompra).build();
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição ItemCompra.insert()");
            return Response.status(Status.NO_CONTENT).build();
        }
    }

    // @Override
    // @Transactional
    // public ItemCompra update(long id, ItemCompra itemcompra){
        
    //     try {
    //         LOG.info("Requisição ItemCompra.update()");
    //         ItemCompra entity = repository.findById(id);
    //         entity.setNome(itemcompra.getNome());
    //         return entity;
            
    //     } catch (Exception e) {
    //         LOG.error("Erro ao rodar Requisição ItemCompra.update()");
    //         return null;
    //     }
        
    // }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        
        try {
            LOG.info("Requisição ItemCompra.delete()");
            repository.deleteById(id);
            return Response.status(Status.OK).build();
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição ItemCompra.delete()");
            return Response.status(Status.NO_CONTENT).build();
        }
        
    }

    
    
}
