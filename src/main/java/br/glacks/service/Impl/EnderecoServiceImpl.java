package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;
import br.glacks.repository.EnderecoRepository;
import br.glacks.service.EnderecoService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    EnderecoRepository repository;
    
    @Override
    public List<EnderecoResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(endereco -> new EnderecoResponseDTO(endereco))
            .collect(Collectors.toList());
        
    }

    @Override
    public EnderecoResponseDTO getId(long id){
        return new EnderecoResponseDTO(repository.findById(id));
        
    }

    @Override
    @Transactional
    public Response insert(Endereco endereco){
        repository.persist(endereco);
        return Response.ok(endereco).build();
    }

    @Override
    @Transactional
    public Endereco update(long id, Endereco endereco){
        Endereco entity = repository.findById(id);
        entity.setNome(endereco.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
