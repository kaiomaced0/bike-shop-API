package br.glacks.resource;

import java.util.List;

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

import br.glacks.model.Telefone;
import br.glacks.repository.TelefoneRepository;
import br.glacks.service.TelefoneService;

@Path("/telefone")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TelefoneResource {
    
    @Inject
    TelefoneService telefoneService;
    

    @GET
    public List<Telefone> gettAll(){
        return telefoneService.getAll();
        
    }

    @GET
    @Path("/{id}")
    public Telefone getId(@PathParam("id") long id){
        return telefoneService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Telefone telefone){
        return telefoneService.insert(telefone);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Telefone update(@PathParam("id") long id, Telefone telefone){
        return telefoneService.update(id, telefone);
    }

    
    
}
