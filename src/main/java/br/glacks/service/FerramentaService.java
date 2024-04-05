package br.glacks.service;

import br.glacks.dto.ProdutoDTO;
import jakarta.ws.rs.core.Response;

public interface FerramentaService {

    public Response getAll();

    public Response getId(Long id);
    public Response insert(ProdutoDTO ferramentaDTO);
    public Response update(Long id, ProdutoDTO p);

}
