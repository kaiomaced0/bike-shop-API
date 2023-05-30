package br.glacks.service.Impl;

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
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {

    
    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    UsuarioService usuarioService;

    @Inject
    FileService fileService;



    @Override
    public Response getPerfilUsuario(){

        // obtendo o login a partir do token
        String login = jsonWebToken.getSubject();
        UsuarioResponseDTO user = usuarioService.findByLogin(login);

        return Response.ok(user).build();

    }

    @Override
    @Transactional
    public Response salvarImagem(@MultipartForm ImageForm form){
        String nomeImagem = "";
        
        try {
            nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNome());
        } catch (IOException e) {
            Result result = new Result(e.getMessage());
            return Response.status(Status.CONFLICT).entity(result).build();
        }

        // obtendo o login a partir do token
        String login = jsonWebToken.getSubject();
        UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

        usuario = usuarioService.updateImagem(usuario.id(), nomeImagem);

        return Response.ok(usuario).build();

    }

    @Override
    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem){
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition","attachment;filename=" + nomeImagem);
        return response.build();

    }
    
}
