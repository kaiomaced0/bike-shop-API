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

