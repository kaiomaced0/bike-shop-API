package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;
import br.glacks.repository.EnderecoRepository;
import br.glacks.service.EnderecoService;
import jakarta.enterprise.context.ApplicationScoped;

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
        Endereco entity = repository.findById(id);
        entity.setAtivo(false);
            
        return Response.status(Status.OK).build();
    }

    
    
}
