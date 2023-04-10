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

import br.glacks.dto.TamanhoDTO;
import br.glacks.model.Tamanho;
import br.glacks.repository.TamanhoRepository;



@Path("/tamanho")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TamanhoResource {

    @Inject
    TamanhoRepository repository;

    @GET
    public List<Tamanho> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Tamanho getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(TamanhoDTO tamanhoDTO){
        if(tamanhoDTO != null){
            
            repository.persist(TamanhoDTO.criarTamanho(tamanhoDTO));
            return Response.ok().build();
        }
        return Response.notModified().build();
        
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Tamanho update(@PathParam("id") long id, TamanhoDTO tamanhoDTO){
        Tamanho entity = repository.findById(id);
        entity.setNome(tamanhoDTO.getNome());
        return entity;
    }
     
}
