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

import br.glacks.model.Categoria;
import br.glacks.repository.CategoriaRepository;


@Path("/categoria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {



    @Inject
    CategoriaRepository repository;
    

    @GET
    public List<Categoria> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Categoria getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Categoria categoria){
        repository.persist(categoria);
        return Response.ok(categoria).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Categoria update(@PathParam("id") long id, Categoria categoria){
        Categoria entity = repository.findById(id);
        entity.setNome(categoria.getNome());
        return entity;
    }
    
}
