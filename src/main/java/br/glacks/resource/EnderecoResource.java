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

import br.glacks.model.Endereco;
import br.glacks.repository.EnderecoRepository;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    EnderecoRepository repository;
    

    @GET
    public List<Endereco> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public  Endereco getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Endereco endereco){
        repository.persist(endereco);
        return Response.ok(endereco).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Endereco update(@PathParam("id") long id, Endereco endereco){
        Endereco entity = repository.findById(id);
        entity.setNome(endereco.getNome());
        return entity;
    }
    
}
