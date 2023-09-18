package br.glacks.service;
import java.util.List;

import br.glacks.dto.EstadoResponseDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.model.locais.Estado;

public interface EstadoService {
    
    public List<EstadoResponseDTO> getAll();

    public EstadoResponseDTO getId(@PathParam("id") long id);

    public Response insert(Estado estadoDTO);

    public Response update(@PathParam("id") long id, Estado estado);
    
    public Response delete(@PathParam("id") Long id);
}
