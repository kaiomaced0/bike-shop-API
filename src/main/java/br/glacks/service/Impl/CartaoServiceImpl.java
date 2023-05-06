package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.dto.CartaoDTO;
import br.glacks.dto.CartaoResponseDTO;
import br.glacks.model.Usuario;
import br.glacks.model.pagamento.Cartao;
import br.glacks.repository.CartaoRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.CartaoService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartaoServiceImpl implements CartaoService {

    @Inject
    CartaoRepository repository;

    @Inject
    UsuarioRepository uRepository;
    
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
        Cartao c = CartaoDTO.criaCartao(cartao);
        c.setUsuario(uRepository.findById(c.getUsuario().getId()));
        repository.persist(c);
        return Response.ok(cartao).build();
    }

    @Override
    @Transactional
    public Cartao update(long id, CartaoDTO cartaoDTO){
        Cartao entity = repository.findById(id);
        entity = CartaoDTO.mudaCartao(entity, cartaoDTO);
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
