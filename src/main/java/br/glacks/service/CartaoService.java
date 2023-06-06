package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.CartaoDTO;
import br.glacks.dto.CartaoResponseDTO;

public interface CartaoService {
    
    public List<CartaoResponseDTO> getAll();

    public CartaoResponseDTO getId(@PathParam("id") long id);

    public Response insert(CartaoDTO cartaoDTO);

    public Response update(@PathParam("id") long id, CartaoDTO cartao);
    
    public Response delete(@PathParam("id") Long id);
}
