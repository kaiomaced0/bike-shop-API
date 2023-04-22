package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.model.PessoaFisica;
import br.glacks.repository.PessoaFisicaRepository;
import br.glacks.service.PessoaFisicaService;

public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Inject
    PessoaFisicaRepository repository;
    
    public List<PessoaFisica> getAll(){
        return repository.findAll().list();
        
    }

    public PessoaFisica getId(long id){
        return repository.findById(id);
        
    }
    
    @Override
    public Response insert(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaFisica = PessoaFisicaDTO.criaPessoaFisica(pessoaFisicaDTO);
        if(pessoaFisicaDTO != null){
            repository.persist(pessoaFisica);
            return Response.ok(pessoaFisicaDTO).build();
        }
        return Response.notModified().build();
        
    }

    public PessoaFisica update(long id, PessoaFisicaDTO pessoafisica){
        PessoaFisica entity = repository.findById(id);
        if(pessoafisica.getUsuarioDTO().getLogin() != null){
            entity.setLogin(pessoafisica.getUsuarioDTO().getLogin());
        }
        if(pessoafisica.getUsuarioDTO().getNome() != null){
            entity.setNome(pessoafisica.getUsuarioDTO().getNome());
        }
        if(pessoafisica.getUsuarioDTO().getSenha() != null){
            entity.setSenha(pessoafisica.getUsuarioDTO().getSenha());
        }
        if(pessoafisica.getCpf() != null){
            entity.setCpf(pessoafisica.getCpf());
        }
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    
}
