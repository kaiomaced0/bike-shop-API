package br.glacks.service.Impl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import br.glacks.model.locais.Estado;
import br.glacks.repository.EstadoRepository;
import br.glacks.service.EstadoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository repository;
    
    @Override
    public List<Estado> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Estado getId(long id){
        return repository.findById(id);
        
    }

    @Override
    @Transactional
    public Response insert(Estado estado){
        repository.persist(estado);
        return Response.ok(estado).build();
    }

    @Override
    @Transactional
    public Estado update(long id, Estado estado){
        Estado entity = repository.findById(id);
        entity.setNome(estado.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
