package br.glacks.resource;


import java.util.List;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.BikeDTO;
import br.glacks.dto.BikeResponseDTO;
import br.glacks.model.bike.Bike;
import br.glacks.service.BikeService;

@Path("/bike")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BikeResource {

    @Inject
    BikeService bikeService;

    @GET
    @PermitAll
    public Response gettAll(){
        return bikeService.getAll();

    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/admin")
    public Response gettAllAdmin(){
        return bikeService.getAllAdmin();

    }

    @GET
    @PermitAll
    @Path("/nome/{nome}")
    public Response getNome(@PathParam("nome") String nome){
        return bikeService.getNome(nome);

    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/admin/{id}")
    public Response getIdAdmin(@PathParam("id") long id){
        return bikeService.getAdminId(id);

    }

    @GET
    @PermitAll
    @Path("/{id}")
    public Response getId(@PathParam("id") long id){
        return bikeService.getId(id);

    }

    @POST
    @Transactional
    @RolesAllowed({"Admin"})
    public Response insert(BikeDTO bike){
        return bikeService.insert(bike);
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") long id, BikeDTO bike){
        return bikeService.update(id, bike);
    }


    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return bikeService.delete(id);
    }

}
