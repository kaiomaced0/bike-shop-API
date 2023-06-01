package br.glacks.resource;
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.model.Usuario;
import br.glacks.service.HashService;
import br.glacks.service.TokenJwtService;
import br.glacks.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    
    @Inject
    HashService hashService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    TokenJwtService tokenService;

    @Inject
    JsonWebToken jsonWebToken;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(AuthUsuarioDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.senha());
        
        Usuario usuario = usuarioService.findByLoginAndSenha(authDTO.login(), hash);

        if (usuario == null) {
            return Response.status(Status.NO_CONTENT)
                .entity("Usuario não encontrado").build();
        } 
        return Response.ok()
            .header("Authorization", tokenService.generateJwt(usuario))
            .build();
        
    }

     

    
}
