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
