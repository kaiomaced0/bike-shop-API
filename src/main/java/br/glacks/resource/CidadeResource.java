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
import br.glacks.service.CidadeService;


@Path("/cidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {



    @Inject
    CidadeService cidadeService;
    

    @GET
    public List<Cidade> gettAll(){
        return cidadeService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    public List<Cidade> getNome(@PathParam("nome") String nome){
        return cidadeService.getNome(nome);
    
    }

    @GET
    @Path("/{id}")
    public Cidade getId(@PathParam("id") long id){
        return cidadeService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Cidade cidade){
        return cidadeService.insert(cidade);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cidade update(@PathParam("id") long id, Cidade cidade){
        return cidadeService.update(id, cidade);
    }
    
}

