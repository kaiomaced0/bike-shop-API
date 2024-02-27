package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.BikeDTO;
import br.glacks.dto.BikeResponseDTO;
import br.glacks.model.bike.Bike;

public interface BikeService {
    
    public Response getAll();

    public Response getId(@PathParam("id") long id);

    public Response getNome(@PathParam("nome") String nome);

    public Response insert(BikeDTO bike);

    public Response update(@PathParam("id") long id, BikeDTO bike);
    
    public Response delete(@PathParam("id") Long id);
}
