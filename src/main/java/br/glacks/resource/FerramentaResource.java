package br.glacks.resource;

import br.glacks.dto.ProdutoDTO;
import br.glacks.service.FerramentaService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ferramenta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FerramentaResource {

    @Inject
    FerramentaService service;

    @GET
    @PermitAll
    @Path("/{page}/{pageSize}")
    public Response getAll(@PathParam("page") int page, @PathParam("pageSize") int pageSize){
        return service.getAll(page, pageSize);
    }

    @GET
    @PermitAll
    @Path("/count")
    public long count(){
        return service.count();
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/admin/{page}/{pageSize}")
    public Response getAllAdmin(@PathParam("page") int page, @PathParam("pageSize") int pageSize){
        return service.getAllAdmin(page, pageSize);
    }


    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response getId(@PathParam("id") Long id){
        return service.getId(id);
    }

    @POST
    @RolesAllowed({"Admin"})
    public Response insert (ProdutoDTO p){
        return service.insert(p);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/update/{id}")
    public Response update (@PathParam("id") Long id, ProdutoDTO p){
        return service.update(id, p);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

}
