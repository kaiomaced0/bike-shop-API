package br.glacks.resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.dto.UsuarioUpdateEmailDTO;
import br.glacks.dto.UsuarioUpdateLoginDTO;
import br.glacks.dto.UsuarioUpdateNomeDTO;
import br.glacks.dto.UsuarioUpdateSenhaDTO;
import br.glacks.form.ImageForm;
import br.glacks.service.UsuarioLogadoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuariologado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {

    @Inject
    UsuarioLogadoService usuarioLogado;

    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/senha")
    @Transactional
    public UsuarioResponseDTO updateSenha(UsuarioUpdateSenhaDTO senha){
        return usuarioLogado.updateSenha(senha);
    }

    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/email")
    @Transactional
    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email){
        return usuarioLogado.updateEmail(email);
    }

    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/login")
    @Transactional
    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login){
        return usuarioLogado.updateLogin(login);
    }

    @PATCH
    @RolesAllowed({"User", "Admin"})
    @Path("/nome")
    @Transactional
    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome){
        return usuarioLogado.updateNome(nome);
    }

    @GET
    @RolesAllowed({"Admin", "User"})
    public UsuarioResponseDTO getPerfilUsuario(){
        return usuarioLogado.getPerfilUsuarioLogado();
        
    }

    @PUT
    @RolesAllowed({"User", "Admin"})
    @Path("/deleteOn/{id}")
    public Response deleteOn() {
        return usuarioLogado.deleteOn();
    }

    @PATCH
    @Path("/novaimagem")
    @RolesAllowed({"Admin", "User"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImageForm form){
        return usuarioLogado.salvarImagem(form);

    }

    @GET
    @Path("/download/{nomeImagem}")
    @RolesAllowed({"Admin", "User"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem){
        
        return usuarioLogado.baixarImagem(nomeImagem);

    }
    
}
