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

import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.dto.UsuarioUpdateDTO;
import br.glacks.model.Usuario;
import br.glacks.service.*;



@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    @RolesAllowed({"Admin"})
    public List<Usuario> getAll(){
        return usuarioService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{nome}")
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
    @PermitAll
    @Transactional
    public Response insert(UsuarioDTO usuarioDTO){
        return usuarioService.insert(usuarioDTO);
        
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/update/{id}")
    @Transactional
    public UsuarioResponseDTO update(@PathParam("id") long id, UsuarioUpdateDTO usuario){
        return usuarioService.update(id, usuario);
    }

    @PUT
    @RolesAllowed({"User"})
    @Path("/{chave}")
    @Transactional
    public UsuarioResponseDTO updateOn(UsuarioUpdateDTO usuario){
        return usuarioService.updateOn(usuario);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return usuarioService.delete(id);
    }

    @PUT
    @RolesAllowed({"User"})
    @Path("/deleteOn/{id}")
    public Response deleteOn() {
        return usuarioService.deleteOn();
    }
    
}
