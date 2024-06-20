package br.glacks.service;

import br.glacks.dto.ProdutoDTO;
import jakarta.ws.rs.core.Response;

public interface FerramentaService {

    public Response getAll(int page, int pageSize);

    public long count();

    public Response getAllAdmin(int page, int pageSize);

    public Response delete(Long id);
    public Response getId(Long id);

    public Response insert(ProdutoDTO ferramentaDTO);
    public Response update(Long id, ProdutoDTO p);

}
