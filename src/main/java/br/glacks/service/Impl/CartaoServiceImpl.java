package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.CartaoDTO;
import br.glacks.dto.CartaoResponseDTO;
import br.glacks.model.Usuario;
import br.glacks.model.pagamento.Cartao;
import br.glacks.repository.CartaoRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.CartaoService;
import br.glacks.service.UsuarioLogadoService;
import br.glacks.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartaoServiceImpl implements CartaoService {

    @Inject
    CartaoRepository repository;

    @Inject
    UsuarioLogadoService usuarioLogado;

    @Inject
    UsuarioService usuarioService;

    @Inject 
    UsuarioRepository usuarioRepository;
    
    @Override
    public List<CartaoResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(cartao -> new CartaoResponseDTO(cartao))
            .collect(Collectors.toList());
    }

    @Override
    public CartaoResponseDTO getId(long id){
        return new CartaoResponseDTO(repository.findById(id));
        
    }

    @Override
    @Transactional
    public Response insert(CartaoDTO cartao){
        try {
            Usuario entityUser = usuarioRepository.findById(usuarioLogado.getPerfilUsuarioLogado().id());
            Cartao c = CartaoDTO.criaCartao(cartao);
            c.setUsuario(entityUser);
            repository.persist(c);
        } catch (Exception e) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
        return Response.ok(cartao).build();
    }

    @Override
    @Transactional
    public Response update(long id, CartaoDTO cartaoDTO){
        try {
            Cartao entity = repository.findById(id);
            if(usuarioLogado.getPerfilUsuarioLogado().id() == entity.getUsuario().getId()){
                entity = CartaoDTO.mudaCartao(entity, cartaoDTO);
            }

            return Response.ok(cartaoDTO).build();

        } catch (Exception e) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
        
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        Cartao entity = repository.findById(id);
        entity.setAtivo(false);
            
        return Response.status(Status.OK).build();
    }

    
    
}
