package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.ProdutoResponseDTO;
import br.glacks.model.Produto;
import br.glacks.repository.ProdutoRepository;
import br.glacks.service.ProdutoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;
    
    @Override
    public List<ProdutoResponseDTO> getAll(){
        return repository.findAll()
        .stream()
        .map(produto -> new ProdutoResponseDTO(produto))
        .collect(Collectors.toList());
        
    }

    @Override
    public Produto getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<Produto> getNome(String nome){
        return repository.findByNome(nome);
        
    }

    @Override
    @Transactional
    public Response insert(Produto produto){
        repository.persist(produto);
        return Response.ok(produto).build();
    }

    @Override
    @Transactional
    public Produto update(long id, Produto produto){
        Produto entity = repository.findById(id);
        entity.setNome(produto.getNome());
        return entity;
    }
    
    @Override
    @Transactional
    public Response delete(Long id) {
        Produto entity = repository.findById(id);
        entity.setAtivo(false);
            
        return Response.status(Status.OK).build();
    }

    @Override
    @Transactional
    public Response retiraEstoque(Long id, int quantidade) {
        Produto entity = repository.findById(id);
        Integer quantidadeTeste = entity.getEstoque() - quantidade;
        if(quantidadeTeste < 0){
            return Response.status(Status.CONFLICT).build();
        }
        else if(quantidadeTeste >= 0){
            entity.setEstoque(entity.getEstoque() - quantidade);
        }
        else{
            return Response.status(Status.CONFLICT).build();
        }
            
        return Response.status(Status.OK).build();
    }

    @Override
   @Transactional
    public Response adicionaEstoque(Long id, int quantidade) {
        Produto entity = repository.findById(id);
        if(quantidade <= 0 ){
            return Response.status(Status.CONFLICT).build();
        }
        try {
            entity.setEstoque(entity.getEstoque() + quantidade);
        } catch (Exception e) {
            return Response.status(Status.CONFLICT).build();
        }
            
        return Response.status(Status.OK).build();
    }

    
    
}
