package br.glacks.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.glacks.model.Compra;
import br.glacks.repository.CompraRepository;
import br.glacks.service.CompraService;

@Path("/compra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

    @Inject
    CompraService compraService;
    

    @GET
    public List<Compra> gettAll(){
        return compraService.getAll();
        
    }

    @GET
    @Path("/{id}")
    public Compra getId(@PathParam("id") long id){
        return compraService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Compra compra){
        return compraService.insert(compra);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Compra update(@PathParam("id") long id, Compra compra){
        return compraService.update(id, compra);
    }

    
    
}
