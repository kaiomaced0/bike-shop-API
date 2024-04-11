package br.glacks.resource;

import br.glacks.dto.FreioDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.service.FreioService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/freio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FreioResource {
    @Inject
    FreioService service;

    @GET
    @PermitAll
    public Response getAll(){
        return service.getAll();
    }

    @GET
    @PermitAll
    @Path("/{id}")
    public Response getId(@PathParam("id") Long id){
        return service.getId(id);
    }

    @POST
    @RolesAllowed({"Admin"})
    public Response insert(FreioDTO f){
        return service.insert(f);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id,FreioDTO f){
        return service.update(id, f);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return service.delete(id);
    }
}

