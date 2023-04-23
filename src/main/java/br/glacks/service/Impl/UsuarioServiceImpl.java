package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.Usuario;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    UsuarioRepository repository;

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
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome());
        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());
        if(usuarioDTO != null){
            repository.persist(usuario);
            return Response.ok(usuario).build();
        }
        return Response.notModified().build();
        
    }

    public Usuario update(long id, UsuarioDTO usuario){
        Usuario entity = repository.findById(id);
        if(usuario.login() != null){
            entity.setLogin(usuario.login());
        }
        if(usuario.nome() != null){
            entity.setNome(usuario.nome());
        }
        if(usuario.senha() != null){
            entity.setSenha(usuario.senha());
        }
        return entity;
    }

    public Response delete(Long id) {
        repository.deleteById(id);
        return Response.status(Status.OK).build();
    }
    
}
