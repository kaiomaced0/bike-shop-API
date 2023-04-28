package br.glacks.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
    public List<UsuarioResponseDTO> getAll(){
        return usuarioService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    public List<UsuarioResponseDTO> getNome(@PathParam("nome") String nome){
        return usuarioService.getNome(nome);
        
    }

    @GET
    @Path("/{id}")
    public Usuario getId(@PathParam("id") long id){
        return usuarioService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(UsuarioDTO usuarioDTO){
        return usuarioService.insert(usuarioDTO);
        
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public UsuarioResponseDTO update(@PathParam("id") long id, UsuarioDTO usuario){
        return usuarioService.update(id, usuario);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return usuarioService.delete(id);
    }
    
}
