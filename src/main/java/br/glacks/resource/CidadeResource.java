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

import br.glacks.model.locais.Cidade;
import br.glacks.repository.CidadeRepository;


@Path("/cidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {



    @Inject
    CidadeRepository repository;
    

    @GET
    public List<Cidade> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Cidade getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Cidade cidade){
        repository.persist(cidade);
        return Response.ok(cidade).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cidade update(@PathParam("id") long id, Cidade cidade){
        Cidade entity = repository.findById(id);
        entity.setNome(cidade.getNome());
        return entity;
    }
    
}

