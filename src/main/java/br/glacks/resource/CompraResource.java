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

import br.glacks.model.Compra;
import br.glacks.repository.CompraRepository;

@Path("/compra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

    @Inject
    CompraRepository repository;
    

    @GET
    public List<Compra> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public  Compra getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Compra compra){
        repository.persist(compra);
        return Response.ok(compra).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Compra update(@PathParam("id") long id, Compra compra){
        Compra entity = repository.findById(id);
        entity.setNome(compra.getNome());
        return entity;
    }

    
    
}
