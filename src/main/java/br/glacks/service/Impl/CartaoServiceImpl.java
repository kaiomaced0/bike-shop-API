package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

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

    public static final Logger LOG = Logger.getLogger(CartaoServiceImpl.class);

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
        try {
            LOG.info("Requisição Cartao.getAll()");
            return repository.findAll()
            .stream()
            .map(CartaoResponseDTO::new)
            .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cartao.getAll()");
            return null;
        }
        
    }

    @Override
    public CartaoResponseDTO getId(long id){
        try {
            LOG.info("Requisição Cartao.getId()");
            return new CartaoResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cartao.getId()");
            return null;
        }
        
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
            LOG.error("Erro ao rodar Requisição Cartao.insert()");
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
        LOG.info("Requisição Cartao.insert()");
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
            LOG.info("Requisição Cartao.update()");
            return Response.ok(cartaoDTO).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cartao.update()");
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }
        
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        try {
            Cartao entity = repository.findById(id);
            entity.setAtivo(false);

            LOG.info("Requisição Cartao.delete()");

            return Response.status(Status.OK).build();

        } catch (Exception e) {
            
            LOG.error("Erro ao rodar Requisição Cartao.delete()");
            return null;
        }
       
    }

    
    
}
