package br.glacks.service.impl;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.*;
import br.glacks.model.EntityClass;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.model.Perfil;
import br.glacks.model.PessoaFisica;
import br.glacks.model.Usuario;
import br.glacks.repository.PessoaFisicaRepository;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.HashService;
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

    @Inject
    HashService hash;

    @Inject
    PessoaJuridicaRepository pessoaJuridicaRepository;
    
    @Inject
    PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public List<UsuarioResponseDTO> getAll() {

        try {
            LOG.info("Requisição Usuario.getAll()");

            return repository.findAll().stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId))
            .map(UsuarioResponseDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.getAll()");
            return null;
        }

    }

    @Override
    public Response getId(long id) {
        try {
            LOG.info("Requisição Usuario.getId()");
            Usuario u = repository.findById(id);
            return Response.ok(new UsuarioResponseDTO(u)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.getId()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    @Transactional
    public Response update(Long id, PessoaFisicaDTO u) {
        try {
            LOG.info("Requisição Usuario.update()");
            PessoaFisica user = new PessoaFisica();
            user = pessoaFisicaRepository.findById(id);
            if(!u.nome().isEmpty()){
                user.setNome(u.nome());
            }
            if(!u.email().isEmpty()){
                user.setEmail(u.email());
            }
            if(!u.login().isEmpty()){
                user.setLogin(u.login());
            }
            if(!u.senha().isEmpty()){
                user.setSenha(hash.getHashSenha(u.senha()));
            }
            if(!u.cpf().isEmpty())
                user.setCpf(u.cpf());

            return Response.ok(new PessoaFisicaResponseDTO(user)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.update()");
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    public List<UsuarioResponseDTO> getNome(String nome) {
        try {
            LOG.info("Requisição Usuario.getNome()");

            return repository.findByNome(nome)
                    .stream()
                    .map(UsuarioResponseDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.getNome()");
            return null;
        }

    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateSenha(Long id, UsuarioUpdateSenhaDTO senha) {
        try {
            LOG.info(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Requisição Usuario.updateSenha() ");

            Usuario entity = repository.findById(id);

            if(!hash.getHashSenha(senha.senhaAnterior()).equals(entity.getSenha()))
                throw new NotFoundException("Senha anterior Incorreta");

            entity.setSenha(hash.getHashSenha(senha.novaSenha()));
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição Usuario.updateSenha()");
            return null;
        }

    }
    
    @Override
    @Transactional
    public UsuarioResponseDTO updateLogin(Long id, UsuarioUpdateLoginDTO login) {
        try {
            LOG.info(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Requisição Usuario.updateLogin()");

            Usuario entity = repository.findById(id);
            if(!hash.getHashSenha(login.senha()).equals(entity.getSenha()))
                throw new NotFoundException("Senha Incorreta");
            
            entity.setLogin(login.login());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição Usuario.updateLogin()");
            return null;
        }

    }
    
    @Override
    @Transactional
    public UsuarioResponseDTO updateNome(Long id, UsuarioUpdateNomeDTO nome) {
        try {
            LOG.info(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Requisição Usuario.updateNome()");

            Usuario entity = repository.findById(id);
            if(entity instanceof PessoaFisica){
                if(!hash.getHashSenha(nome.senha()).equals(entity.getSenha()))
                    throw new NotFoundException("Senha Incorreta");
            PessoaFisica p = pessoaFisicaRepository.findById(entity.getId());
            p.setNome(nome.nome());
            }
            
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição Usuario.updateNome()");
            return null;
        }

    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateEmail(Long id, UsuarioUpdateEmailDTO email) {
        try {
            LOG.info(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Requisição Usuario.updateEmail()");

            Usuario entity = repository.findById(id);
            if(!hash.getHashSenha(email.senha()).equals(entity.getSenha()))
                throw new NotFoundException("Senha Incorreta");
            
            entity.setEmail(email.email());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(usuarioLogado.getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição Usuario.updateEmail()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(PessoaFisicaDTO pessoaFisicaDTO) {
        try {
            LOG.info("Requisição Usuario.insert()");
            PessoaFisica p = PessoaFisicaDTO.criaPessoaFisica(pessoaFisicaDTO);
                if(p.getPerfis() == null){
                p.setPerfis(new HashSet<>());
            }
            Usuario u = repository.findByLogin(pessoaFisicaDTO.login());
            if(u != null){
                throw new Exception("Login ja existe!");
            }
            p.getPerfis().add(Perfil.USER);
            p.setSenha(hash.getHashSenha(p.getSenha()));
            pessoaFisicaRepository.persist(p);
            return Response.ok(new PessoaFisicaResponseDTO(p)).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.insert()" + e.getMessage());
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateImagem(long id, String nomeImagem) {
        try {
            LOG.info("Requisição Usuario.updateImagem()");

            Usuario entity = repository.findById(id);
            entity.setImage(nomeImagem);

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
            if (usuario == null)
                throw new NotFoundException("Usuario não encontrado");

            return new UsuarioResponseDTO(usuario);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.findByLogin()");
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
            LOG.error("Erro ao rodar Requisição Usuario.delete()" + e.getMessage());
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response resetarSenha(Long id) {
        try {
            LOG.info("entrou resetarSenha");
            Usuario u = repository.findById(id);
            u.setSenha(hash.getHashSenha("123"));
            return Response.ok().build();
        }catch (Exception e){
            LOG.error("erro resetarSenha - " + e.getMessage());
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

}
