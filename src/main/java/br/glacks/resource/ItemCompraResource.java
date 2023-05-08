package br.glacks.resource;


import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.glacks.model.ItemCompra;
import br.glacks.repository.ItemCompraRepository;
import br.glacks.service.ItemCompraService;


@Path("/itemcompra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemCompraResource {

    @Inject
    ItemCompraService itemCompraService;

    @GET
    public List<ItemCompra> gettAll(){
        return itemCompraService.getAll();
        
    }

    @GET
    @Path("/{id}")
    public ItemCompra getId(@PathParam("id") long id){
        return itemCompraService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(ItemCompra itemcompra){
        return itemCompraService.insert(itemcompra);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public ItemCompra update(@PathParam("id") long id, ItemCompra itemcompra){
        return itemCompraService.update(id, itemcompra);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return itemCompraService.delete(id);
    }
    
}

