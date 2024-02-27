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

import br.glacks.dto.CartaoDTO;
import br.glacks.dto.CartaoResponseDTO;
import br.glacks.service.CartaoService;

@Path("/cartao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartaoResource {
    
    @Inject
    CartaoService cartaoService;
    

    @GET
    @RolesAllowed({"Admin"})
    public Response gettAll(){
        return cartaoService.getAll();
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response getId(@PathParam("id") long id){
        return cartaoService.getId(id);
        
    }

    @POST
    @Transactional
    @RolesAllowed({"Admin", "User"})
    public Response insert(CartaoDTO cartao){
        return cartaoService.insert(cartao);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Admin", "User"})
    @Transactional
    public Response update(@PathParam("id") long id, CartaoDTO cartao){
        return cartaoService.update(id, cartao);
    }

    
    @PUT
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return cartaoService.delete(id);
    }
    
}
