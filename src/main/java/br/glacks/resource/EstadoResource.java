package br.glacks.resource;


import java.util.List;

import br.glacks.dto.EstadoResponseDTO;
import jakarta.annotation.security.PermitAll;
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

import br.glacks.model.locais.Estado;
import br.glacks.service.EstadoService;


@Path("/estado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResource {



    @Inject
    EstadoService estadoService;
    

    @GET
    @PermitAll
    public List<EstadoResponseDTO> gettAll(){
        return estadoService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public EstadoResponseDTO getId(@PathParam("id") long id){
        return estadoService.getId(id);
        
    }

    @POST
    @RolesAllowed({"Admin"})
    @Transactional
    public Response insert(Estado estado){
        return estadoService.insert(estado);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") long id, Estado estado){
        return estadoService.update(id, estado);
    }

    
    @PUT
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return estadoService.delete(id);
    }
    
}
