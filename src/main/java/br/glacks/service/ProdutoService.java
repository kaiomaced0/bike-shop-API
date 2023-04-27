package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Produto;

public interface ProdutoService {
    
    public List<Produto> getAll();

    public Produto getId(@PathParam("id") long id);

    public List<Produto> getNome(@PathParam("nome") String nome);

    public Response insert(Produto produtoDTO);

    public Produto update(@PathParam("id") long id, Produto produto);
    
    public Response delete(@PathParam("id") Long id);
}
