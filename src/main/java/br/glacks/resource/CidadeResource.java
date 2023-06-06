package br.glacks.resource;


import java.util.List;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.glacks.model.locais.Cidade;
import br.glacks.service.CidadeService;


@Path("/cidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {

    @Inject
    CidadeService cidadeService;
    

    @GET
    @PermitAll
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
    @RolesAllowed({"Admin"})
    public Cidade getId(@PathParam("id") long id){
        return cidadeService.getId(id);
        
    }

    @POST
    @Transactional
    @RolesAllowed({"Admin"})
    public Response insert(Cidade cidade){
        return cidadeService.insert(cidade);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @RolesAllowed({"Admin"})
    public Cidade update(@PathParam("id") long id, Cidade cidade){
        return cidadeService.update(id, cidade);
    }
    
}

