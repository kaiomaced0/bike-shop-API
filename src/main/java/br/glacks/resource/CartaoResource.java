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

import br.glacks.model.pagamento.Cartao;
import br.glacks.repository.CartaoRepository;
import br.glacks.service.CartaoService;

@Path("/cartao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartaoResource {
    
    @Inject
    CartaoService cartaoService;
    

    @GET
    public List<Cartao> gettAll(){
        return cartaoService.getAll();
        
    }

    @GET
    @Path("/{id}")
    public Cartao getId(@PathParam("id") long id){
        return cartaoService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Cartao cartao){
        return cartaoService.insert(cartao);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cartao update(@PathParam("id") long id, Cartao cartao){
        return cartaoService.update(id, cartao);
    }

    
    
}
