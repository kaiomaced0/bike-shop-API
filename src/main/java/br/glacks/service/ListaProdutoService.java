package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.ListaProduto;

public interface ListaProdutoService {
    
    public List<ListaProduto> getAll();

    public ListaProduto getId(@PathParam("id") long id);

    public Response insert(ListaProduto listaprodutoDTO);

    public ListaProduto update(@PathParam("id") long id, ListaProduto listaproduto);
    
    public Response delete(@PathParam("id") Long id);
}
