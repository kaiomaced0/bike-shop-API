package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.model.locais.Estado;

public interface EstadoService {
    
    public List<Estado> getAll();

    public Estado getId(@PathParam("id") long id);

    public Response insert(Estado estadoDTO);

    public Estado update(@PathParam("id") long id, Estado estado);
    
    public Response delete(@PathParam("id") Long id);
}
