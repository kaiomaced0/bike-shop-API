package br.glacks.resource;

import java.util.List;

import br.glacks.dto.ProdutoAdminResponseDTO;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.form.ImageForm;
import br.glacks.model.Produto;
import br.glacks.service.ProdutoService;



@Path("/produto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoService produtoService;
    

    @GET
    @PermitAll
    public List<ProdutoResponseDTO> gettAll(){
        return produtoService.getAll();
        
    }
    @GET
    @RolesAllowed({"Admin"})
    @Path("/admin")
    public List<ProdutoAdminResponseDTO> getAllAdmin(){
        return produtoService.getAllAdmin();

    }

    @GET
    @PermitAll
    @Path("/nome/{nome}")
    public Response getNome(@PathParam("nome") String nome){
        return produtoService.getNome(nome);
        
    }

    @GET
    @Path("/{id}")
    @PermitAll
    public ProdutoResponseDTO getId(@PathParam("id") Long id){
        return produtoService.getId(id);
        
    }

    @GET
    @Path("/admin/{id}")
    @RolesAllowed({"Admin"})
    public ProdutoAdminResponseDTO getIdAdmin(@PathParam("id") Long id){
        return produtoService.getIdAdmin(id);

    }

    @POST
    @RolesAllowed({"Admin"})
    @Transactional
    public Response insert(ProdutoDTO produto){
        return produtoService.insert(produto);
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") long id, ProdutoDTO produto){
        return produtoService.update(id, produto);
    }

    
    @PATCH
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return  produtoService.delete(id);
    }

    @PATCH
    @Path("/novaimagem")
    @RolesAllowed({"Admin"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImageForm form, Integer idProduto){
        return produtoService.salvarImagem(form, idProduto.longValue());

    }
    
}
