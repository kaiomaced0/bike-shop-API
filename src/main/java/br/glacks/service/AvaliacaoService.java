package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.AvaliacaoDTO;
import br.glacks.dto.AvaliacaoResponseDTO;
import br.glacks.model.Avaliacao;

public interface AvaliacaoService {
    
    public List<AvaliacaoResponseDTO> getAll();

    public AvaliacaoResponseDTO getId(@PathParam("id") long id);

    public Response insert(AvaliacaoDTO avaliacaoDTO);

    public Avaliacao update(@PathParam("id") long id, Avaliacao avaliacao);
    
    public Response delete(@PathParam("id") Long id);
}
