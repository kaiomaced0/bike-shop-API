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

import br.glacks.model.Cupom;
import br.glacks.repository.CupomRepository;

@Path("/cupom")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CupomResource {

    @Inject
    CupomRepository repository;
    

    @GET
    public List<Cupom> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public  Cupom getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Cupom cupom){
        repository.persist(cupom);
        return Response.ok(cupom).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cupom update(@PathParam("id") long id, Cupom cupom){
        Cupom entity = repository.findById(id);
        entity.setNome(cupom.getNome());
        return entity;
    }
}
