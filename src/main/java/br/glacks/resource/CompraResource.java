package br.glacks.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.ItemCompraDTO;
import br.glacks.dto.ValidaCompraResponseDTO;
import br.glacks.model.ItemCompra;
import br.glacks.repository.CompraRepository;
import br.glacks.repository.ItemCompraRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.CompraDTO;
import br.glacks.dto.CompraResponseDTO;
import br.glacks.model.Compra;
import br.glacks.service.CompraService;

@Path("/compra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

    @Inject
    CompraService compraService;

    @Inject
    CompraRepository repository; //vou tirar depois, é apenas pra ajudar nos testes
    @Inject
    ItemCompraRepository itemCompraRepository; //teste

    @GET
    @RolesAllowed({"Admin"})
    public Response gettAll(){
        return compraService.getAll();
        
    }

    @GET
    @RolesAllowed({"Admin", "User"})
    @Path("/getValor")
    public Response getValorTeste(List<ItemCompraDTO> listaItemCompra) {
        return compraService.getValorTeste(listaItemCompra);

    }

    @POST
    @RolesAllowed({"Admin", "User"})
    @Path("/verifica")
    public ValidaCompraResponseDTO verificarCompra(CompraDTO compra) {
        return compraService.verificarCompra(compra);
    }

    @PATCH
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/atualizacompras")
    public Response atualizaCompras(){ // ajudar nos testes
        try {
            repository.findAll().stream().forEach(compra -> {
                Compra c = new Compra();
                c = repository.findById(compra.getId());
                compra.setValorTotal(0.0);
                compra.getListaItemCompra().stream().forEach(itemCompra -> {
                    ItemCompra it = new ItemCompra();
                    itemCompra.setPreco(itemCompra.getProduto().getPreco() * itemCompra.getQuantidade());
                    it.setPreco(itemCompra.getPreco());
                    compra.setValorTotal(itemCompra.getPreco() + compra.getValorTotal());

                });
                c.setValorTotal(compra.getValorTotal());
            });
            return Response.ok(repository.findAll().stream().map(CompraResponseDTO::new).collect(Collectors.toList())).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/on")
    @RolesAllowed({"User", "Admin"})
    public List<CompraResponseDTO> gettAllOn(){
        return compraService.getAllOn();
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public CompraResponseDTO getId(@PathParam("id") long id){
        return compraService.getId(id);
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response mudarStatusPedido(@PathParam("id") long id, int idStatusPedido){
        return compraService.mudarStatusPedido(id, idStatusPedido);
        
    }

    @POST
    @Transactional
    @RolesAllowed({"User", "UserCnpj"})
    public Response insert(CompraDTO compra){
        return compraService.insert(compra);
    }

    // @PUT
    // @Path("/{id}")
    // @Transactional
    // @RolesAllowed({"Admin"})
    // public Compra update(@PathParam("id") long id, Compra compra){
    //     return compraService.update(id, compra);
    // }

    
    @PUT
    @RolesAllowed({"Admin"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return compraService.delete(id);
    }
    
    
}
