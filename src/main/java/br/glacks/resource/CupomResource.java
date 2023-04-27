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

import br.glacks.model.Cupom;
import br.glacks.repository.CupomRepository;
import br.glacks.service.CupomService;

@Path("/cupom")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CupomResource {

    @Inject
    CupomService cupomService;
    

    @GET
    public List<Cupom> gettAll(){
        return cupomService.getAll();
        
    }

    @GET
    @Path("/nome/{nome}")
    public List<Cupom> getNome(@PathParam("nome") String nome){
        return cupomService.getNome(nome);
    
    }

    @GET
    @Path("/{id}")
    public Cupom getId(@PathParam("id") long id){
        return cupomService.getId(id);
        
    }

    @POST
    @Transactional
    public Response insert(Cupom cupom){
        return cupomService.insert(cupom);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cupom update(@PathParam("id") long id, Cupom cupom){
        return cupomService.update(id, cupom);
    }
}
