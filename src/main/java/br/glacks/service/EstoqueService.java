package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Estoque;

public interface EstoqueService {
    
    public List<Estoque> getAll();

    public Estoque getId(@PathParam("id") long id);

    public Response insert(Estoque estoqueDTO);

    public Estoque update(@PathParam("id") long id, Estoque estoque);
    
    public Response delete(@PathParam("id") Long id);
}
