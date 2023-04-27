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

import br.glacks.model.Produto;
import br.glacks.repository.ProdutoRepository;
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
