package br.glacks.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.Carrinho;
import br.glacks.model.Usuario;
import br.glacks.repository.CarrinhoRepository;
import br.glacks.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    UsuarioRepository repository;

    @Inject
    CarrinhoRepository carrinhoRepository;

    public List<UsuarioResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(usuario -> new UsuarioResponseDTO(usuario))
            .collect(Collectors.toList());
        
    }

    public Usuario getId(long id){
        return repository.findById(id);
        
    }

    public Response insert(UsuarioDTO usuarioDTO){
        Usuario usuario = UsuarioDTO.criaUsuario(usuarioDTO);
        if(usuarioDTO != null){
            Carrinho carrinho = new Carrinho();
            carrinhoRepository.persist(carrinho);
            usuario.setCarrinho(carrinho);
            repository.persist(usuario);
            return Response.ok(usuario).build();
        }
        return Response.notModified().build();
        
    }

    public Usuario update(long id, UsuarioDTO usuario){
        Usuario entity = repository.findById(id);
        if(usuario.getLogin() != null){
            entity.setLogin(usuario.getLogin());
        }
        if(usuario.getNome() != null){
            entity.setNome(usuario.getNome());
        }
        if(usuario.getSenha() != null){
            entity.setSenha(usuario.getSenha());
        }
        return entity;
    }

    public Response delete(Long id) {
        Usuario entity = repository.findById(id);
        if(entity.getPedidos() == null){
            repository.deleteById(id);
            return Response.status(Status.OK).build();
        }
        return Response.status(Status.UNAUTHORIZED).build();
    }
    
}
