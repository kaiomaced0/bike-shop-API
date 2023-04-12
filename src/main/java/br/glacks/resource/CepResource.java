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

import br.glacks.model.locais.Cep;
import br.glacks.repository.CepRepository;


@Path("/cep")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CepResource {


    @Inject
    CepRepository repository;
    

    @GET
    public List<Cep> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Cep getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Cep cep){
        repository.persist(cep);
        return Response.ok(cep).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cep update(@PathParam("id") long id, Cep cep){
        Cep entity = repository.findById(id);
        entity.setNome(cep.getNome());
        return entity;
    }
    
}
