package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.locais.Estado;
import br.glacks.repository.EstadoRepository;
import br.glacks.service.EstadoService;

public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository repository;
    
    public List<Estado> getAll(){
        return repository.findAll().list();
        
    }

    public Estado getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Estado estado){
        repository.persist(estado);
        return Response.ok(estado).build();
    }

    @Transactional
    public Estado update(long id, Estado estado){
        Estado entity = repository.findById(id);
        entity.setNome(estado.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
