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

import br.glacks.model.Estoque;
import br.glacks.repository.EstoqueRepository;



@Path("/estoque")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstoqueResource {

    @Inject
    EstoqueRepository repository;
    

    @GET
    public List<Estoque> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Estoque getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Estoque estoque){
        repository.persist(estoque);
        return Response.ok(estoque).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Estoque update(@PathParam("id") long id, Estoque estoque){
        Estoque entity = repository.findById(id);
        entity.setNome(estoque.getNome());
        return entity;
    }
    
}
