package br.glacks.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
