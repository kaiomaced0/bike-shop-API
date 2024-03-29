package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.AvaliacaoDTO;
import br.glacks.dto.AvaliacaoResponseDTO;

public interface AvaliacaoService {
    
    public Response getAll();

    public Response getId(@PathParam("id") long id);

    public Response insert(AvaliacaoDTO avaliacaoDTO);

    public Response update(@PathParam("id") long id, AvaliacaoDTO avaliacao);
    
    public Response delete(@PathParam("id") Long id);
}
