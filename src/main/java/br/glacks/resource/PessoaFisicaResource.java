package br.glacks.resource;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import br.glacks.dto.PessoaFisicaResponseDTO;
import br.glacks.model.PessoaFisica;
import br.glacks.service.PessoaFisicaService;

@Path("/pessoafisica")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaFisicaResource {
    @Inject
    PessoaFisicaService pessoaFisicaService;


    @GET
    @RolesAllowed({"Admin"})
    public List<PessoaFisicaResponseDTO> getAll(){
        return pessoaFisicaService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/nome/{nome}")
    public List<PessoaFisicaResponseDTO> getNome(@PathParam("nome") String nome){
        return pessoaFisicaService.getNome(nome);
    
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public PessoaFisica getId(@PathParam("id") long id){
        return pessoaFisicaService.getId(id);
        
    }

}
