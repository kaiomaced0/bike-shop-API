package br.glacks.resource;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.glacks.model.ItemCompra;
import br.glacks.repository.ItemCompraRepository;


@Path("/itemcompra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemCompraResource {

    @Inject
    ItemCompraRepository repository;

    @GET
    public List<ItemCompra> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public ItemCompra getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(ItemCompra itemcompra){
        repository.persist(itemcompra);
        return Response.ok(itemcompra).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public ItemCompra update(@PathParam("id") long id, ItemCompra itemcompra){
        ItemCompra entity = repository.findById(id);
        if(itemcompra.getQuantidade() != null){
            entity.setQuantidade(itemcompra.getQuantidade());
        }
        if(itemcompra.getNome() != null){
            entity.setNome(itemcompra.getNome());
        }
        if(itemcompra.getProduto() != null){
            entity.setNome(itemcompra.getNome());
        }
        return entity;
    }

    @DELETE
    @Path("/{id}")
    public ItemCompra delete(@PathParam("id") Long id) {
        ItemCompra entity = repository.findById(id);
        return entity;
    }
    
}

