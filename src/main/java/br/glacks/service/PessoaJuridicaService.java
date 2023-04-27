package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.model.PessoaJuridica;

public interface PessoaJuridicaService {
    
    public List<PessoaJuridica> getAll();

    public PessoaJuridica getId(@PathParam("id") long id);

    public List<PessoaJuridica> getNome(@PathParam("nome") String nome);

    public Response insert(PessoaJuridicaDTO pessoajuridicaDTO);

    public PessoaJuridica update(@PathParam("id") long id, PessoaJuridicaDTO pessoajuridica);
    
    public Response delete(@PathParam("id") Long id);
}
