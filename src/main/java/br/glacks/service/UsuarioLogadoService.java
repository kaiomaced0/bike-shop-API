package br.glacks.service;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.dto.UsuarioUpdateEmailDTO;
import br.glacks.dto.UsuarioUpdateLoginDTO;
import br.glacks.dto.UsuarioUpdateNomeDTO;
import br.glacks.dto.UsuarioUpdateSenhaDTO;
import br.glacks.form.ImageForm;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface UsuarioLogadoService {

    public UsuarioResponseDTO updateSenha(UsuarioUpdateSenhaDTO senha);
    
    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login);
    
    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome);

    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email);
    
    public UsuarioResponseDTO getPerfilUsuarioLogado();

    public Response deleteOn();

    public Response salvarImagem(@MultipartForm ImageForm form);

    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem);
}
