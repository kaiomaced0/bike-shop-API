package br.glacks.resource;

import java.util.List;

import br.glacks.dto.*;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    public List<UsuarioResponseDTO> getAll(){
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
    public Usuario getId(@PathParam("id") long id){
        return usuarioService.getId(id);
        
    }

    @POST
    @PermitAll
    @Transactional
    public Response insert(PessoaFisicaDTO p){
        return usuarioService.insert(p);
        
    }

    // @PUT
    // @RolesAllowed({"Admin"})
    // @Path("/update/{id}")
    // @Transactional
    // public UsuarioResponseDTO update(@PathParam("id") long id, UsuarioDTO usuario){
    //     return usuarioService.update(id, usuario);
    // }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/senha/{id}")
    @Transactional
    public UsuarioResponseDTO updateSenha(@PathParam("id") Long id, UsuarioUpdateSenhaDTO senha){
        return usuarioService.updateSenha(id, senha);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/email/{id}")
    @Transactional
    public UsuarioResponseDTO updateEmail(@PathParam("id") Long id, UsuarioUpdateEmailDTO email){
        return usuarioService.updateEmail(id, email);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/login/{id}")
    @Transactional
    public UsuarioResponseDTO updateLogin(@PathParam("id") Long id, UsuarioUpdateLoginDTO login){
        return usuarioService.updateLogin(id, login);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/nome/{id}")
    @Transactional
    public UsuarioResponseDTO updateNome(@PathParam("id") Long id, UsuarioUpdateNomeDTO nome){
        return usuarioService.updateNome(id, nome);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return usuarioService.delete(id);
    }

    
}
