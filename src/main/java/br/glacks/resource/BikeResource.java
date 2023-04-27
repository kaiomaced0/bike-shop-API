package br.glacks.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
