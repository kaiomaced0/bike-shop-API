package br.glacks.resource;

import java.util.List;

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

import br.glacks.model.bike.Bike;
import br.glacks.repository.BikeRepository;
import br.glacks.service.BikeService;

@Path("/bike")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BikeResource {
    
    @Inject
    BikeService bikeService;
    
    @GET
    public List<Bike> gettAll(){
        return bikeService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    public List<Bike> getNome(@PathParam("nome") String nome){
        return bikeService.getNome(nome);
    
    }

    @GET
    @Path("/{id}")
    public Bike getId(@PathParam("id") long id){
        return bikeService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Bike bike){
        return bikeService.insert(bike);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Bike update(@PathParam("id") long id, Bike bike){
        return bikeService.update(id, bike);
    }

    
    
}
