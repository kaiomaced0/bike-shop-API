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

@Path("/bike")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BikeResource {
    
    @Inject
    BikeRepository repository;
    

    @GET
    public List<Bike> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Bike getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Bike bike){
        repository.persist(bike);
        return Response.ok(bike).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Bike update(@PathParam("id") long id, Bike bike){
        Bike entity = repository.findById(id);
        entity.setNome(bike.getNome());
        return entity;
    }

    
    
}
