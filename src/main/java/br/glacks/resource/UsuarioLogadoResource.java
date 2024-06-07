package br.glacks.resource;

import br.glacks.dto.*;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.form.ImageForm;
import br.glacks.service.UsuarioLogadoService;
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
    public PessoaFisicaResponseDTO getPerfilUsuario(){
        return usuarioLogado.getPerfilPessoaFisicaLogado();
        
    }

    @PUT
    @Path("/updatedados")
    @RolesAllowed({"Admin", "User"})
    public Response updateDados(UsuarioLogadoDadosDTO u) {
        return usuarioLogado.updateDados(u);
    }

    @GET
    @Path("/gostei")
    @RolesAllowed({"Admin", "User"})
    public Response getGostei(){
        return usuarioLogado.getGostei();

    }

    @GET
    @Path("/enderecos")
    @RolesAllowed({"Admin", "User"})
    public Response getEnderecos(){
        return usuarioLogado.enderecos();
    }

    @PATCH
    @Path("/gostei/insert/{id}")
    @RolesAllowed({"Admin", "User"})
    public Response insertGostei(@PathParam("id") long id){
        return usuarioLogado.gosteiInsert(id);

    }
    @PATCH
    @Path("/gostei/delete/{id}")
    @RolesAllowed({"Admin", "User"})
    public Response deleteGostei(@PathParam("id") long id){
        return usuarioLogado.gosteiDelete(id);

    }

    @POST
    @Path("/telefone")
    @RolesAllowed({"User", "Admin"})
    public Response insertTelefone(TelefoneUsuarioLogadoDTO dto){
        return usuarioLogado.telefoneInsert(dto);
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

    @POST
    @Path("/endereco")
    @RolesAllowed({"Admin", "User"})
    public Response insertEndereco(EnderecoDTO endereco) {
        return usuarioLogado.insertEndereco(endereco);
    }

    
}
