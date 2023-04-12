package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.pagamento.Cartao;

public interface CartaoService {
    
    public List<Cartao> getAll();

    public Cartao getId(@PathParam("id") long id);

    public Response insert(Cartao cartaoDTO);

    public Cartao update(@PathParam("id") long id, Cartao cartao);
    
    public Response delete(@PathParam("id") Long id);
}
