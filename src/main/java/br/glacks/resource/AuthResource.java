package br.glacks.resource;

import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.service.UsuarioLogadoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.glacks.dto.AuthPessoaJuridicaDTO;
import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.model.PessoaFisica;
import br.glacks.model.PessoaJuridica;
import br.glacks.model.Usuario;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.service.HashService;
import br.glacks.service.TokenJwtService;
import br.glacks.service.UsuarioService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
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
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Inject
    TokenJwtService tokenService;

    @Inject
    JsonWebToken jsonWebToken;

    @POST
    @PermitAll
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

    @GET
    @RolesAllowed({"Admin"})
    @Path("/verificaadmin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificaAdmin() {
        try {

            return Response.ok(true).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

//    @POST
//    @PermitAll
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response loginCNPJ(AuthPessoaJuridicaDTO authDTO) {
//        String hash = hashService.getHashSenha(authDTO.senha());
//
//        Usuario usuario = usuarioService.findByLoginAndSenha(authDTO.login(), hash);
//        if (usuario == null) {
//            return Response.status(Status.NO_CONTENT)
//                    .entity("Usuario não encontrado").build();
//        }
//
//        PessoaJuridica pj = pessoaJuridicaRepository.findByCnpj(authDTO.cnpj()).get(0);
//
//        if (usuario instanceof PessoaFisica)
//            for (Usuario i : pj.getUsuariosResponsaveis()) {
//                if (i.getId() == usuario.getId()) {
//                    return Response.ok()
//                            .header("Authorization - Empresa: " + pj.getRazaoSocial() + " ",
//                                    tokenService.generateJwtJuridico(usuario))
//                            .build();
//                }
//            }
//
//        if (usuario instanceof PessoaJuridica)
//            if (usuario.getId() == pj.getId()) {
//                if (pj.getSenha() == hash) {
//                    return Response.ok()
//                            .header("Authorization - Empresa: " + pj.getRazaoSocial() + " ",
//                                    tokenService.generateJwt(pj))
//                            .build();
//                }
//            }
//
//        return Response.status(Status.NO_CONTENT)
//                .entity("Usuario não tem acesso").build();
//
//    }

}
