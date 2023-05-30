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
import br.glacks.model.pagamento.Cartao;
import br.glacks.repository.CartaoRepository;
import br.glacks.service.CartaoService;

@Path("/cartao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartaoResource {
    
    @Inject
    CartaoService cartaoService;
    

    @GET
    @RolesAllowed({"Admin"})
    public List<CartaoResponseDTO> gettAll(){
        return cartaoService.getAll();
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public CartaoResponseDTO getId(@PathParam("id") long id){
        return cartaoService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(CartaoDTO cartao){
        return cartaoService.insert(cartao);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cartao update(@PathParam("id") long id, CartaoDTO cartao){
        return cartaoService.update(id, cartao);
    }

    
    
}
