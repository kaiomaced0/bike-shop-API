package br.glacks.resource;

import java.util.List;

import br.glacks.dto.CupomResponseDTO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.CupomDTO;
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
    public List<CupomResponseDTO> gettAll(){
        return cupomService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    @RolesAllowed({"Admin"})
    public List<CupomResponseDTO> getNome(@PathParam("nome") String nome){
        return cupomService.getNome(nome);
    
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public CupomResponseDTO getId(@PathParam("id") long id){
        return cupomService.getId(id);
        
    }

    @GET
    @Path("/verificar/{codigo}")
    @RolesAllowed({"Admin", "User"})
    public CupomResponseDTO verificar(@PathParam("codigo") String codigo){
        return cupomService.getCodigo(codigo);

    }

    @POST
    @Transactional
    @RolesAllowed({"Admin"})
    public Response insert(CupomDTO cupom){
        return cupomService.insert(cupom);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") long id, CupomDTO cupom){
        return cupomService.update(id, cupom);
    }

    
    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return cupomService.delete(id);
    }
}
