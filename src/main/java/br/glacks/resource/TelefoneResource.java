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
import br.glacks.dto.TelefoneDTO;
import br.glacks.dto.TelefoneResponseDTO;
import br.glacks.model.Telefone;
import br.glacks.service.TelefoneService;

@Path("/telefone")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TelefoneResource {
    
    @Inject
    TelefoneService telefoneService;    

    @GET
    @RolesAllowed({"Admin"})
    public List<TelefoneResponseDTO> gettAll(){
        return telefoneService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public TelefoneResponseDTO getId(@PathParam("id") long id){
        return telefoneService.getId(id);
        
    }

//    @POST
//    @RolesAllowed({"Admin", "User"})
//    @Transactional
//    public Response insert(TelefoneDTO telefone){
//        return telefoneService.insert(telefone);
//    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/update/{id}")
    @Transactional
    public TelefoneResponseDTO update(@PathParam("id") Long id, TelefoneDTO telefone){
        return telefoneService.update(id, telefone);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return telefoneService.delete(id);
    }

    
    
}
