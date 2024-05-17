package br.glacks.resource;

import br.glacks.service.impl.HomeConfigService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/home")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HomeResource {

    @Inject
    HomeConfigService service;

    @GET
    @Path("/carrossel")
    @PermitAll
    public Response getCarrossel(){
        return service.getCarrossel();
    }
    @GET
    @Path("/destaques")
    @PermitAll
    public Response getDestaques() {
        return service.getDestaques();
    }


}
