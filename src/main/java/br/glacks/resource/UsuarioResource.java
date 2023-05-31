package br.glacks.resource;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.Usuario;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.*;
import br.glacks.service.Impl.UsuarioServiceImpl;



@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;


    @GET
    @RolesAllowed({"Admin"})
    public List<UsuarioResponseDTO> getAll(){
        return usuarioService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/nome/{nome}")
    public List<UsuarioResponseDTO> getNome(@PathParam("nome") String nome){
        return usuarioService.getNome(nome);
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public UsuarioResponseDTO getId(@PathParam("id") long id){
        return usuarioService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(UsuarioDTO usuarioDTO){
        return usuarioService.insert(usuarioDTO);
        
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    @Transactional
    public UsuarioResponseDTO update(@PathParam("id") long id, UsuarioDTO usuario){
        return usuarioService.update(id, usuario);
    }

    @PUT
    @RolesAllowed({"Admin", "User"})
    @Path("/{chave}")
    @Transactional
    public UsuarioResponseDTO updateOn(@PathParam("chave") String chave, UsuarioDTO usuario){
        return usuarioService.updateOn(chave, usuario);
    }

    @DELETE
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return usuarioService.delete(id);
    }
    
}
