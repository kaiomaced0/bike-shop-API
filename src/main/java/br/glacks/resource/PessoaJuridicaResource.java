package br.glacks.resource;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.PessoaJuridicaResponseDTO;
import br.glacks.model.PessoaJuridica;
import br.glacks.service.PessoaJuridicaService;

@Path("/pessoajuridica")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaJuridicaResource {

    @Inject
    PessoaJuridicaService pessoaJuridicaService;

    @GET
    @RolesAllowed({"Admin"})
    public List<PessoaJuridicaResponseDTO> getAll(){
        return pessoaJuridicaService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/nome/{nome}")
    public List<PessoaJuridicaResponseDTO> getNome(@PathParam("nome") String nome){
        return pessoaJuridicaService.getNome(nome);
    
    }

    @GET
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    public PessoaJuridica getId(@PathParam("id") long id){
        return pessoaJuridicaService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(PessoaJuridicaDTO pessoajuridicaDTO){
        return pessoaJuridicaService.insert(pessoajuridicaDTO);
        
    }

    @PUT
    @RolesAllowed({"Admin", "User"})
    @Path("/{id}")
    @Transactional
    public PessoaJuridicaResponseDTO update(@PathParam("id") long id, PessoaJuridicaDTO pessoajuridica){
        return pessoaJuridicaService.update(id, pessoajuridica);
    }

    @PUT
    @RolesAllowed({"Admin", "User"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return pessoaJuridicaService.delete(id);
    }
    
}
