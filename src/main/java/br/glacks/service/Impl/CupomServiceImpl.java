package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Cupom;
import br.glacks.repository.CupomRepository;
import br.glacks.service.CupomService;

public class CupomServiceImpl implements CupomService {

    @Inject
    CupomRepository repository;
    
    public List<Cupom> getAll(){
        return repository.findAll().list();
        
    }

    public Cupom getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(Cupom cupom){
        repository.persist(cupom);
        return Response.ok(cupom).build();
    }

    @Transactional
    public Cupom update(long id, Cupom cupom){
        Cupom entity = repository.findById(id);
        entity.setNome(cupom.getNome());
        return entity;
    }
    
   @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
