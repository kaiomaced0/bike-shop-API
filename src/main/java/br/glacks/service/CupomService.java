package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Cupom;

public interface CupomService {
    
    public List<Cupom> getAll();

    public Cupom getId(@PathParam("id") long id);

    public Response insert(Cupom cupomDTO);

    public Cupom update(@PathParam("id") long id, Cupom cupom);
    
    public Response delete(@PathParam("id") Long id);
}
