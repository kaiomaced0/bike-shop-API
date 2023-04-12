package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Categoria;

public interface CategoriaService {
    
    public List<Categoria> getAll();

    public Categoria getId(@PathParam("id") long id);

    public Response insert(Categoria categoriaDTO);

    public Categoria update(@PathParam("id") long id, Categoria categoria);
    
    public Response delete(@PathParam("id") Long id);
}
