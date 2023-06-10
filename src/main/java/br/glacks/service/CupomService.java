package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.CupomDTO;
import br.glacks.dto.CupomResponseDTO;
import br.glacks.model.Cupom;

public interface CupomService {
    
    public List<Cupom> getAll();

    public Cupom getId(@PathParam("id") long id);

    public List<Cupom> getNome(@PathParam("nome") String nome);

    public Response insert(CupomDTO cupomDTO);

    public CupomResponseDTO getCodigo(@PathParam("codigo") String codigo);

    public Cupom update(@PathParam("id") long id, CupomDTO cupom);
    
    public Response delete(@PathParam("id") Long id);
}
