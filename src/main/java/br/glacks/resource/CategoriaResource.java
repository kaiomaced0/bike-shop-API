package br.glacks.resource;

import br.glacks.dto.CategoriaDTO;
import br.glacks.service.CategoriaService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categoria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {
    @Inject
    CategoriaService service;

    @GET
    @PermitAll
    public Response getAll(){
        return service.getAll();
    }

    @GET
    @PermitAll
    @Path("/admin/{page}/{pageSize}")
    public Response getAllAdmin(@PathParam("page") int page, @PathParam("pageSize") int pageSize){
        return service.getAllAdmin(page, pageSize);
    }

    @GET
    @PermitAll
    @Path("/count")
    public long count(){
        return service.count();
    }

    @GET
    @PermitAll
    @Path("/{id}")
    public Response getId(@PathParam("id") Long id){
        return service.getId(id);
    }

    @POST
    @RolesAllowed({"Admin"})
    public Response insert(CategoriaDTO c){
        return service.insert(c);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id,CategoriaDTO c){
        return service.update(id, c);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return service.delete(id);
    }


}

