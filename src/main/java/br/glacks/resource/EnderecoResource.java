package br.glacks.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;
import br.glacks.repository.EnderecoRepository;
import br.glacks.service.EnderecoService;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    EnderecoService enderecoService;
    

    @GET
    public List<EnderecoResponseDTO> gettAll(){
        return enderecoService.getAll();
        
    }

    @GET
    @Path("/{id}")
    public EnderecoResponseDTO getId(@PathParam("id") long id){
        return enderecoService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Endereco endereco){
        return enderecoService.insert(endereco);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Endereco update(@PathParam("id") long id, Endereco endereco){
        return enderecoService.update(id, endereco);
    }
    
}
