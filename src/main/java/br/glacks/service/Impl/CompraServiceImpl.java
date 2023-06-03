package br.glacks.service.Impl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.model.Compra;
import br.glacks.model.ItemCompra;
import br.glacks.model.StatusPedido;
import br.glacks.model.Usuario;
import br.glacks.repository.CompraRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.CompraService;
import br.glacks.service.ProdutoService;
import br.glacks.service.UsuarioLogadoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraServiceImpl implements CompraService {

    @Inject
    CompraRepository repository;

    @Inject
    UsuarioLogadoService usuarioLogado;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject 
    ProdutoService produtoService;
    
    @Override
    public List<Compra> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Compra getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public Response mudarStatusPedido(long id, int idStatusPedido){
        Compra entity = repository.findById(id);
        try {
            entity.setStatusPedido(StatusPedido.valueOf(idStatusPedido));
        } catch (Exception e) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
        return Response.status(Status.OK).build();
        
    }

    @Override
    @Transactional
    public Response insert(Compra compra){
        if(compra != null){
            
            Usuario entity = usuarioRepository.findByLogin(
                usuarioLogado.getPerfilUsuarioLogado().login());
            compra.setUsuario(entity);
            compra.setStatusPedido(StatusPedido.PREPARANDO);

            for (ItemCompra item : compra.getListaItemCompra()) {
                try {
                    produtoService.retiraEstoque(item.getProduto().getId(), item.getQuantidade());
                } catch (Exception e) {
                    return Response.status(Status.NO_CONTENT).build();
                }
            }
            repository.persist(compra);

            return Response.ok(compra).build();
        }
        return Response.status(Status.NO_CONTENT).build();
    
    }

    @Override
    @Transactional
    public Compra update(long id, Compra compra){
        Compra entity = repository.findById(id);
        entity.setNome(compra.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        Compra entity = repository.findById(id);
        entity.setAtivo(false);
            
        return Response.status(Status.OK).build();
    }

    @Override
    @Transactional
    public Response realizarPagamentoCompra(long id, String tokenPagamento){
        
        Compra entity = getId(id);
        if(entity != null){
            entity.setStatusPedido(StatusPedido.PREPARANDO);
            entity.setPago(true);
            entity.setToken(tokenPagamento);
            return Response.status(Status.OK).build();
        }
        else{


        return Response.status(Status.NOT_ACCEPTABLE).build();
        }
    }
    
    
}
