package br.glacks.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.glacks.model.Produto;
import br.glacks.service.ProdutoService;



@Path("/produto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoService produtoService;
    

    @GET
    public List<Produto> gettAll(){
        return produtoService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    public List<Produto> getNome(@PathParam("nome") String nome){
        return produtoService.getNome(nome);
        
    }
    
    @GET
    @Path("/{id}")
    public Produto getId(@PathParam("id") long id){
        return produtoService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Produto produto){
        return produtoService.insert(produto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Produto update(@PathParam("id") long id, Produto produto){
        return produtoService.update(id, produto);
    }
    
}
