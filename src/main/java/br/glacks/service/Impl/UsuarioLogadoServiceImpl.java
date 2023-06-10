package br.glacks.service.impl;

import java.io.IOException;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.application.Result;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.form.ImageForm;
import br.glacks.service.FileService;
import br.glacks.service.UsuarioLogadoService;
import br.glacks.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {

    public static final Logger LOG = Logger.getLogger(UsuarioLogadoServiceImpl.class);

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    UsuarioService usuarioService;
    
        @Inject
        FileService fileService;

    @Override
    public Response getPerfilUsuario() {

        try {
            LOG.info("Requisição Telefone.getPerfilUsuario()");

            // obtendo o login a partir do token
            String login = jsonWebToken.getSubject();
            UsuarioResponseDTO user = usuarioService.findByLogin(login);

            return Response.ok(user).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getPerfilUsuario()");
            return null;
        }

    }

    @Override
    public UsuarioResponseDTO getPerfilUsuarioLogado() {

        try {
            LOG.info("Requisição Telefone.getPerfilUsuarioLogado()");

            String login = jsonWebToken.getSubject();
            UsuarioResponseDTO user = usuarioService.findByLogin(login);

            return user;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getPerfilUsuarioLogado()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response salvarImagem(@MultipartForm ImageForm form) {
        String nomeImagem = "";

        try {
            nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNome());
            // obtendo o login a partir do token
            String login = jsonWebToken.getSubject();
            UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

            usuario = usuarioService.updateImagem(usuario.id(), nomeImagem);

            LOG.info("Requisição UsuarioLogado.salvarImagem()");

            return Response.ok(usuario).build();
        } catch (IOException e) {
            Result result = new Result(e.getMessage());

            LOG.error("Erro ao rodar Requisição UsuarioLogado.salvarImagem()");

            return Response.status(Status.CONFLICT).entity(result).build();
        }

    }

    @Override
    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem) {

        try {
            LOG.info("Requisição UsuarioLogado.baixarImagem()");

            ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
            response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
            return response.build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição UsuarioLogado.baixarImagem()");
            return null;
        }

    }

}
