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

import br.glacks.model.ListaProduto;
import br.glacks.repository.ListaProdutoRepository;


@Path("/listaproduto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ListaProdutoResource {

    @Inject
    ListaProdutoRepository repository;

    @GET
    public List<ListaProduto> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public ListaProduto getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(ListaProduto listaproduto){
        repository.persist(listaproduto);
        return Response.ok(listaproduto).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public ListaProduto update(@PathParam("id") long id, ListaProduto listaproduto){
        ListaProduto entity = repository.findById(id);
        entity.setNome(listaproduto.getNome());
        return entity;
    }
    
}

