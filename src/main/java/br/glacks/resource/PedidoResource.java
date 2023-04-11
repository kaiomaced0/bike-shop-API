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

import br.glacks.dto.PedidoResponseDTO;
import br.glacks.model.Pedido;
import br.glacks.repository.PedidoRepository;



@Path("/pedido")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoRepository repository;
    

    @GET
    public List<PedidoResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(pedido -> new PedidoResponseDTO(pedido))
            .collect(Collectors.toList());
        
    }

    @GET
    @Path("/{id}")
    public Pedido getId(@PathParam("id") long id){
        return repository.findById(id);
        
    }

    @POST
    @Transactional
    public Response insert(Pedido pedido){
        repository.persist(pedido);
        return Response.ok(pedido).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Pedido update(@PathParam("id") long id, Pedido pedido){
        Pedido entity = repository.findById(id);
        entity.setNome(pedido.getNome());
        return entity;
    }
    
}