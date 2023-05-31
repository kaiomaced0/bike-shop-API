package br.glacks.resource;

import java.util.List;

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

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;
import br.glacks.service.EnderecoService;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    EnderecoService enderecoService;
    

    @GET
    @RolesAllowed({"Admin"})
    public List<EnderecoResponseDTO> gettAll(){
        return enderecoService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public EnderecoResponseDTO getId(@PathParam("id") long id){
        return enderecoService.getId(id);
        
    }

    @POST    
    @RolesAllowed({"Admin", "User"})
    @Transactional
    public Response insert(Endereco endereco){
        return enderecoService.insert(endereco);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    @Transactional
    public Endereco update(@PathParam("id") long id, Endereco endereco){
        return enderecoService.update(id, endereco);
    }
    
}
