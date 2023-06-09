package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.Usuario;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.UsuarioLogadoService;
import br.glacks.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    public static final Logger LOG = Logger.getLogger(UsuarioServiceImpl.class);
    
    @Inject
    UsuarioRepository repository;

    @Inject
    UsuarioLogadoService usuarioLogado;

    @Override
    public List<UsuarioResponseDTO> getAll(){
        
        try {
            LOG.info("Requisição Usuario.getAll()");

            return repository.findAll().stream()
            .map(usuario -> new UsuarioResponseDTO(usuario))
            .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.getAll()");
            return null;
        }            
        
    }

    @Override
    public UsuarioResponseDTO getId(long id){
        try {
            LOG.info("Requisição Usuario.getId()");

            return new UsuarioResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.getId()");
            return null;
        }            
        
        
    }

    @Override
    public List<UsuarioResponseDTO> getNome(String nome){
        try {
            LOG.info("Requisição Usuario.getNome()");

            return repository.findByNome(nome)
            .stream()
            .map(usuario -> new UsuarioResponseDTO(usuario))
            .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.getNome()");
            return null;
        }            
                
    }

    @Override
    @Transactional
    public Response insert(UsuarioDTO usuarioDTO){
        try {
            LOG.info("Requisição Usuario.insert()");
        
            Usuario usuario = UsuarioDTO.criaUsuario(usuarioDTO);
            if(usuarioDTO != null){
                repository.persist(usuario);
                return Response.ok(usuario).build();
            }
            return Response.notModified().build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.insert()");
            return null;
        }            
        
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(long id, UsuarioDTO usuario){
        try {
            LOG.info("Requisição Usuario.update()");

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
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.update()");
            return null;
        }            
        
    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateOn(String chave, UsuarioDTO usuario){
        try {
            LOG.info("Requisição Usuario.updateOn()");

            Usuario entity = repository.findByLogin(usuarioLogado.getPerfilUsuarioLogado().login());
            if(usuario.login() != null){
                entity.setLogin(usuario.login());
            }
            if(usuario.nome() != null){
                entity.setNome(usuario.nome());
            }
            if(usuario.senha() != null){
                entity.setSenha(usuario.senha());
            }
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.updateOn()");
            return null;
        }            
        
    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateImagem(long id, String nomeImagem){
        try {
            LOG.info("Requisição Usuario.updateImagem()");
        
            Usuario entity = repository.findById(id);

            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.updateImagem()");
            return null;
        }            
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        try {
            LOG.info("Requisição Usuario.findByLoginAndSenha()");

            return repository.findByLoginAndSenha(login, senha);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.findByLoginAndSenha()");
            return null;
        }            
        
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        try {
            LOG.info("Requisição Usuario.findByLogin()");

            Usuario usuario = repository.findByLogin(login);
            if(usuario == null)
                throw new NotFoundException("Usuario não encontrado");
    
            return new UsuarioResponseDTO(usuario);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.findByLogin()");
            return null;
        }            
        
    }

    @Override
    public Usuario findByLoginUsuarioLogado(String login) {
        try {
            LOG.info("Requisição Usuario.findByLoginUsuarioLogado()");

            Usuario usuario = repository.findByLogin(login);
            if(usuario == null)
                throw new NotFoundException("Usuario não encontrado");
    
            return usuario;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.findByLoginUsuarioLogado()");
            return null;
        }            
        
    }


    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Usuario.delete()");
        
            Usuario entity = repository.findById(id);
            entity.setAtivo(false);
            
            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.delete()");
            return null;
        }            
    }
    
}
