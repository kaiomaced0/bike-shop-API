package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.dto.CartaoDTO;
import br.glacks.dto.CartaoResponseDTO;
import br.glacks.model.pagamento.Cartao;

public interface CartaoService {
    
    public List<CartaoResponseDTO> getAll();

    public CartaoResponseDTO getId(@PathParam("id") long id);

    public Response insert(CartaoDTO cartaoDTO);

    public Cartao update(@PathParam("id") long id, CartaoDTO cartao);
    
    public Response delete(@PathParam("id") Long id);
}
