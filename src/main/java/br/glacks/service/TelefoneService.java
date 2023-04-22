package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Telefone;


public interface TelefoneService {
    
    public List<Telefone> getAll();

    public Telefone getId(@PathParam("id") long id);

    public Response insert(Telefone telefone);

    public Telefone update(@PathParam("id") long id, Telefone telefone);
    
    public Response delete(@PathParam("id") Long id);
}
