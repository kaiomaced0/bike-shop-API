package br.glacks.resource;

import br.glacks.form.ImageForm;
import br.glacks.service.FileService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Path("/file")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FileResource {
    @Inject
    FileService service;

    @POST
    @Path("/novaimagem")
    @RolesAllowed({"Admin", "User"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImageForm form) throws IOException {
            String imagem = service.salvarImagemProduto(form.getImagem(), form.getNome());
            if(imagem == null){
                return Response.status(500).build();
            }
        Map<String, String> map = new HashMap<>();
            map.put("imagem", imagem);
            return Response.ok(map).build();
    }

    @GET
    @Path("/download/{nomeImagem}")
    @PermitAll
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem){

        Response.ResponseBuilder response = Response.ok(service.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();

    }
}
