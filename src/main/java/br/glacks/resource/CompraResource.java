package br.glacks.resource;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
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
import br.glacks.dto.CompraDTO;
import br.glacks.dto.CompraResponseDTO;
import br.glacks.model.Compra;
import br.glacks.service.CompraService;

@Path("/compra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

    @Inject
    CompraService compraService;
    

    @GET
    @RolesAllowed({"Admin"})
    public Response gettAll(){
        return compraService.getAll();
        
    }

    @GET
    @Path("/on")
    @RolesAllowed({"User", "Admin"})
    public List<CompraResponseDTO> gettAllOn(){
        return compraService.getAllOn();
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public CompraResponseDTO getId(@PathParam("id") long id){
        return compraService.getId(id);
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response mudarStatusPedido(@PathParam("id") long id, int idStatusPedido){
        return compraService.mudarStatusPedido(id, idStatusPedido);
        
    }

    @POST
    @Transactional
    @RolesAllowed({"User", "UserCnpj"})
    public Response insert(CompraDTO compra){
        return compraService.insert(compra);
    }

    // @PUT
    // @Path("/{id}")
    // @Transactional
    // @RolesAllowed({"Admin"})
    // public Compra update(@PathParam("id") long id, Compra compra){
    //     return compraService.update(id, compra);
    // }

    
    @PUT
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return compraService.delete(id);
    }
    
    
}
