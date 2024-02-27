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

import br.glacks.dto.AvaliacaoDTO;
import br.glacks.dto.AvaliacaoResponseDTO;
import br.glacks.service.AvaliacaoService;

@Path("/avaliacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AvaliacaoResource {
    
    @Inject
    AvaliacaoService avaliacaoService;
    

    @GET
    @RolesAllowed({"Admin"})
    public Response gettAll(){
        return avaliacaoService.getAll();
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response getId(@PathParam("id") long id){
        return avaliacaoService.getId(id);
        
    }

    @POST
    @RolesAllowed({"Admin", "User"})
    @Transactional
    public Response insert(AvaliacaoDTO avaliacao){
        return avaliacaoService.insert(avaliacao);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") long id, AvaliacaoDTO avaliacao){
        return avaliacaoService.update(id, avaliacao);
    }

    
    
}
