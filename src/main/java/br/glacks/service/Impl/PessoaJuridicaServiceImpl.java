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
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome(pessoaJuridicaDTO.usuarioDTO().nome());
        pessoaJuridica.setLogin(pessoaJuridicaDTO.usuarioDTO().login());
        pessoaJuridica.setSenha(pessoaJuridicaDTO.usuarioDTO().senha());
        pessoaJuridica.setCnpj(pessoaJuridicaDTO.cnpj());
        if(pessoaJuridicaDTO != null){
            repository.persist(pessoaJuridica);
            return Response.ok(pessoaJuridicaDTO).build();
        }
        return Response.notModified().build();
        
    }

    @Override
    public PessoaJuridica update(long id, PessoaJuridicaDTO pessoaJuridica){
        PessoaJuridica entity = repository.findById(id);
        if(pessoaJuridica.usuarioDTO().login() != null){
            entity.setLogin(pessoaJuridica.usuarioDTO().login());
        }
        if(pessoaJuridica.usuarioDTO().nome() != null){
            entity.setNome(pessoaJuridica.usuarioDTO().nome());
        }
        if(pessoaJuridica.usuarioDTO().senha() != null){
            entity.setSenha(pessoaJuridica.usuarioDTO().senha());
        }
        if(pessoaJuridica.cnpj() != null){
            entity.setCnpj(pessoaJuridica.cnpj());
        }
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
