package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.PessoaJuridica;
import br.glacks.repository.PessoaJuridicaRepository;

public class CarrinhoServiceImpl implements PessoaJuridicaService {

    @Inject
    PessoaJuridicaRepository repository;
    
    public List<PessoaJuridica> getAll(){
        return repository.findAll().list();
        
    }

    public PessoaJuridica getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(PessoaJuridica pessoajuridica){
        repository.persist(pessoajuridica);
        return Response.ok(pessoajuridica).build();
    }

    @Transactional
    public PessoaJuridica update(long id, PessoaJuridica pessoajuridica){
        PessoaJuridica entity = repository.findById(id);
        entity.setNome(pessoajuridica.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
