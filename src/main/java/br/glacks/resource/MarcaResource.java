package br.glacks.resource;

import br.glacks.dto.MarcaDTO;
import br.glacks.service.MarcaService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/marca")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcaResource {

    @Inject
    MarcaService service;

    @GET
    @PermitAll
    public Response getAll(){
        return service.getAll();
    }
    @GET
    @Path("/{id}")
    @PermitAll
    public Response getId(@PathParam("id") Long id){
        return service.getId(id);
    }

    @POST
    @RolesAllowed({"Admin"})
    public Response insert (MarcaDTO m){
        return service.insert(m);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/update/{id}")
    public Response update (@PathParam("id") Long id, MarcaDTO m){
        return service.update(id, m);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

}
