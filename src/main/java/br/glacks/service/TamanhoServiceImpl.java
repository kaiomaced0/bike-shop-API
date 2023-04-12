package br.glacks.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.glacks.dto.TamanhoDTO;
import br.glacks.model.Tamanho;
import br.glacks.repository.TamanhoRepository;

public class TamanhoServiceImpl implements TamanhoService {
    @Inject
    TamanhoRepository repository;

    public List<Tamanho> gettAll(){
        return repository.findAll().list();
        
    }

    public Tamanho getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(TamanhoDTO tamanhoDTO){
        if(tamanhoDTO != null){
            
            repository.persist(TamanhoDTO.criarTamanho(tamanhoDTO));
            return Response.ok().build();
        }
        return Response.notModified().build();
        
    }

    public Tamanho update(Long id, TamanhoDTO tamanhoDTO){
        Tamanho entity = repository.findById(id);
        entity.setNome(tamanhoDTO.getNome());
        return entity;
    }

    @Override
    public List<Tamanho> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Tamanho update(long id, TamanhoDTO tamanho) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
