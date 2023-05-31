package br.glacks.service;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.form.ImageForm;
import br.glacks.model.Usuario;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface UsuarioLogadoService {
    public Response getPerfilUsuario();

    public UsuarioResponseDTO getPerfilUsuarioLogado();

    public Response salvarImagem(@MultipartForm ImageForm form);

    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem);
}
