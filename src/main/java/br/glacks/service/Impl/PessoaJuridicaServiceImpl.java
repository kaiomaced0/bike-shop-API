package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.model.PessoaJuridica;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.service.PessoaJuridicaService;

public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

    @Inject
    PessoaJuridicaRepository repository;
    
    public List<PessoaJuridica> getAll(){
        return repository.findAll().list();
        
    }

    public PessoaJuridica getId(long id){
        return repository.findById(id);
        
    }
    @Override
    public Response insert(PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridica pessoaJuridica = PessoaJuridicaDTO.criaPessoaJuridica(pessoaJuridicaDTO);
        if(pessoaJuridicaDTO != null){
            repository.persist(pessoaJuridica);
            return Response.ok(pessoaJuridicaDTO).build();
        }
        return Response.notModified().build();
        
    }

    @Override
    public PessoaJuridica update(long id, PessoaJuridicaDTO pessoajuridica){
        PessoaJuridica entity = repository.findById(id);
        entity.setNome(pessoajuridica.getUsuarioDTO().getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
