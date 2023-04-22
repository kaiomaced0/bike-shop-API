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

import br.glacks.model.Avaliacao;
import br.glacks.repository.AvaliacaoRepository;

@Path("/avaliacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AvaliacaoResource {
    
    @Inject
    AvaliacaoRepository repository;
    

    @GET
    public List<Avaliacao> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Avaliacao getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Avaliacao avaliacao){
        repository.persist(avaliacao);
        return Response.ok(avaliacao).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Avaliacao update(@PathParam("id") long id, Avaliacao avaliacao){
        Avaliacao entity = repository.findById(id);
        entity.setNome(avaliacao.getNome());
        return entity;
    }

    
    
}
