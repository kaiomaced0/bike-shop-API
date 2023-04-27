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

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.PessoaFisica;
import br.glacks.model.Usuario;
import br.glacks.repository.PessoaFisicaRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.PessoaFisicaService;

@Path("/pessoafisica")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaFisicaResource {
    @Inject
    PessoaFisicaService pessoaFisicaService;


    @GET
    public List<PessoaFisica> getAll(){
        return pessoaFisicaService.getAll();
        
    }

    @GET
    @Path("/{id}")
    public PessoaFisica getId(@PathParam("id") long id){
        return pessoaFisicaService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(PessoaFisicaDTO pessoaFisicaDTO){
        return pessoaFisicaService.insert(pessoaFisicaDTO);
        
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public PessoaFisica update(@PathParam("id") long id, PessoaFisicaDTO pessoafisica){
        return pessoaFisicaService.update(id, pessoafisica);

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return pessoaFisicaService.delete(id);

    }
    
}
