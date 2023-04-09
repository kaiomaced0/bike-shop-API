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

import br.glacks.model.Usuario;
import br.glacks.repository.UsuarioRepository;



@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioRepository repository;


    @GET
    public List<Usuario> gettAll(){
        return repository.findAll().list();
        
    }

    @GET
    @Path("/{id}")
    public Usuario getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Usuario usuario){
        repository.persist(usuario);
        return Response.ok(usuario).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Usuario update(@PathParam("id") long id, Usuario usuario){
        Usuario entity = repository.findById(id);
        if(usuario.getLogin() != null){
            entity.setLogin(usuario.getLogin());
        }
        if(usuario.getNome() != null){
            entity.setNome(usuario.getNome());
        }
        if(usuario.getSenha() != null){
            entity.setSenha(usuario.getSenha());
        }
        return entity;
    }
    
}
