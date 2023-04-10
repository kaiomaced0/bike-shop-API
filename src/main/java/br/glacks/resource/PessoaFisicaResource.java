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

@Path("/pessoafisica")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaFisicaResource {
    @Inject
    PessoaFisicaRepository repository;

    @Inject
    UsuarioRepository usuarioRepository;


    @GET
    public List<UsuarioResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(usuario -> new UsuarioResponseDTO(usuario))
            .collect(Collectors.toList());
        
    }

    @GET
    @Path("/{id}")
    public PessoaFisica getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaFisica = PessoaFisicaDTO.criaPessoaFisica(pessoaFisicaDTO);
        if(pessoaFisicaDTO != null){
            repository.persist(pessoaFisica);
            return Response.ok(pessoaFisica).build();
        }
        return Response.notModified().build();
        
    }

    @POST
    @Transactional
    @Path("/{id}")
    public Response insert(@PathParam("id") long id){
        Usuario entity = usuarioRepository.findById(id);
        PessoaFisica pessoaFisica = (PessoaFisica) entity;
        if(pessoaFisica != null){
            repository.persist(pessoaFisica);
            return Response.ok(pessoaFisica).build();
        }
        return Response.notModified().build();
        
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public PessoaFisica update(@PathParam("id") long id, PessoaFisicaDTO pessoafisica){
        PessoaFisica entity = repository.findById(id);
        if(pessoafisica.getUsuarioDTO().getLogin() != null){
            entity.setLogin(pessoafisica.getUsuarioDTO().getLogin());
        }
        if(pessoafisica.getUsuarioDTO().getNome() != null){
            entity.setNome(pessoafisica.getUsuarioDTO().getNome());
        }
        if(pessoafisica.getUsuarioDTO().getSenha() != null){
            entity.setSenha(pessoafisica.getUsuarioDTO().getSenha());
        }
        if(pessoafisica.getCpf() != null){
            entity.setCpf(pessoafisica.getCpf());
        }
        return entity;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        PessoaFisica entity = repository.findById(id);
        if(entity.getPedidos() == null){
            repository.deleteById(id);
            return Response.status(Status.OK).build();
        }
        return Response.status(Status.UNAUTHORIZED).build();
    }
    
}
