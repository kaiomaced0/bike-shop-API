package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.Usuario;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.UsuarioService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    UsuarioRepository repository;

    @Override
    public List<UsuarioResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(usuario -> new UsuarioResponseDTO(usuario))
            .collect(Collectors.toList());
        
    }

    @Override
    public Usuario getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<Usuario> getNome(String nome){
        return repository.findByNome(nome);
        
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
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

    @Override
    @Transactional
    public Response delete(Long id) {
        repository.deleteById(id);
        return Response.status(Status.OK).build();
    }
    
}
