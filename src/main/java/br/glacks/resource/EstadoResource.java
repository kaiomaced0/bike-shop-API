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

import br.glacks.model.locais.Estado;
import br.glacks.repository.EstadoRepository;


@Path("/estado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResource {



    @Inject
    EstadoRepository repository;
    

    @GET
    public List<Estado> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Estado getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Estado estado){
        repository.persist(estado);
        return Response.ok(estado).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Estado update(@PathParam("id") long id, Estado estado){
        Estado entity = repository.findById(id);
        entity.setNome(estado.getNome());
        return entity;
    }
    
}
