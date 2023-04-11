package br.glacks.resource;

import java.util.List;
import java.util.stream.Collectors;

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

import br.glacks.dto.CarrinhoResponseDTO;
import br.glacks.model.Carrinho;
import br.glacks.repository.CarrinhoRepository;

@Path("/carrinho")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarrinhoResource {

    @Inject
    CarrinhoRepository repository;
    

    @GET
    public List<CarrinhoResponseDTO> gettAll(){
        return repository.findAll()
                .stream()
                .map(carrinho -> new CarrinhoResponseDTO(carrinho))
                .collect(Collectors.toList());
        
    }
    @GET
    @Path("/{id}")
    public Carrinho getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    
    @POST
    @Transactional
    public Response insert(Carrinho carrinho){
        repository.persist(carrinho);
        return Response.ok(carrinho).build();
    }

    @PUT
    @Transactional
    public Carrinho update(@PathParam("id") long id, Carrinho carrinho){
        Carrinho entity = repository.findById(id);
        entity.setNome(carrinho.getNome());
        entity.setUsuario(carrinho.getUsuario());
        return entity;
    }

}