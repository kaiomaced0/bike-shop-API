package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.model.PessoaFisica;

public interface PessoaFisicaService {
    
    public List<PessoaFisica> getAll();

    public PessoaFisica getId(@PathParam("id") long id);

    public Response insert(PessoaFisicaDTO pessoaFisicaDTO);

    public PessoaFisica update(@PathParam("id") long id, PessoaFisicaDTO pessoaFisica);
    
    public Response delete(@PathParam("id") Long id);
}
