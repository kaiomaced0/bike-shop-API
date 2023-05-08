package br.glacks.resource;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.PessoaJuridicaResponseDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.PessoaJuridica;
import br.glacks.model.Usuario;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.PessoaJuridicaService;

@Path("/pessoajuridica")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaJuridicaResource {

    @Inject
    PessoaJuridicaService pessoaJuridicaService;

    @GET
    public List<PessoaJuridicaResponseDTO> getAll(){
        return pessoaJuridicaService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    public List<PessoaJuridicaResponseDTO> getNome(@PathParam("nome") String nome){
        return pessoaJuridicaService.getNome(nome);
    
    }

    @GET
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
    @Path("/{id}")
    @Transactional
    public PessoaJuridicaResponseDTO update(@PathParam("id") long id, PessoaJuridicaDTO pessoajuridica){
        return pessoaJuridicaService.update(id, pessoajuridica);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return pessoaJuridicaService.delete(id);
    }
    
}
