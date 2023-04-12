package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Cor;

public interface CorService {
    
    public List<Cor> getAll();

    public Cor getId(@PathParam("id") long id);

    public Response insert(Cor corDTO);

    public Cor update(@PathParam("id") long id, Cor cor);
    
    public Response delete(@PathParam("id") Long id);
}
