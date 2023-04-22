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
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.PessoaJuridica;
import br.glacks.model.Usuario;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.repository.UsuarioRepository;

@Path("/pessoajuridica")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaJuridicaResource {

    @Inject
    PessoaJuridicaRepository repository;

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
    public PessoaJuridica getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(PessoaJuridicaDTO pessoajuridicaDTO){
        PessoaJuridica pessoajuridica = PessoaJuridicaDTO.criaPessoaJuridica(pessoajuridicaDTO);
        if(pessoajuridicaDTO != null){
            repository.persist(pessoajuridica);
            return Response.ok(pessoajuridicaDTO).build();
        }
        return Response.notModified().build();
        
    }

    @POST
    @Transactional
    @Path("/{id}")
    public Response insert(@PathParam("id") long id){
        Usuario entity = usuarioRepository.findById(id);
        PessoaJuridica pessoajuridica = (PessoaJuridica) entity;
        if(pessoajuridica != null){
            repository.persist(pessoajuridica);
            return Response.ok(pessoajuridica).build();
        }
        return Response.notModified().build();
        
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public PessoaJuridica update(@PathParam("id") long id, PessoaJuridicaDTO pessoajuridica){
        PessoaJuridica entity = repository.findById(id);
        if(pessoajuridica.getUsuarioDTO().getLogin() != null){
            entity.setLogin(pessoajuridica.getUsuarioDTO().getLogin());
        }
        if(pessoajuridica.getUsuarioDTO().getNome() != null){
            entity.setNome(pessoajuridica.getUsuarioDTO().getNome());
        }
        if(pessoajuridica.getUsuarioDTO().getSenha() != null){
            entity.setSenha(pessoajuridica.getUsuarioDTO().getSenha());
        }
        if(pessoajuridica.getCnpj() != null){
            entity.setCnpj(pessoajuridica.getCnpj());
        }
        return entity;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        PessoaJuridica entity = repository.findById(id);
        repository.deleteById(id);
        return Response.status(Status.OK).build();
    }
    
}
