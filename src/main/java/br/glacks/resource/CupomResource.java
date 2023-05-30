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

import br.glacks.model.Cupom;
import br.glacks.service.CupomService;

@Path("/cupom")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CupomResource {

    @Inject
    CupomService cupomService;
    

    @GET
    @RolesAllowed({"Admin"})
    public List<Cupom> gettAll(){
        return cupomService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    @RolesAllowed({"Admin"})
    public List<Cupom> getNome(@PathParam("nome") String nome){
        return cupomService.getNome(nome);
    
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Cupom getId(@PathParam("id") long id){
        return cupomService.getId(id);
        
    }

    @POST
    @Transactional
    @RolesAllowed({"Admin"})
    public Response insert(Cupom cupom){
        return cupomService.insert(cupom);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @RolesAllowed({"Admin"})
    public Cupom update(@PathParam("id") long id, Cupom cupom){
        return cupomService.update(id, cupom);
    }
}
