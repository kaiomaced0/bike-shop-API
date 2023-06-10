package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.TelefoneDTO;
import br.glacks.dto.TelefoneResponseDTO;
import br.glacks.model.Telefone;


public interface TelefoneService {
    
    public List<TelefoneResponseDTO> getAll();

    public TelefoneResponseDTO getId(@PathParam("id") long id);

    public Response insert(TelefoneDTO telefone);

    public TelefoneResponseDTO update(@PathParam("id") long id, TelefoneDTO telefone);

    public Response delete(@PathParam("id") Long id);
}
