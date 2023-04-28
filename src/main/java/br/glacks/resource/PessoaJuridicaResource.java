package br.glacks.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
