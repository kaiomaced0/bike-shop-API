package br.glacks.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.*;
import br.glacks.model.*;
import br.glacks.repository.*;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.glacks.application.Result;
import br.glacks.form.ImageForm;
import br.glacks.service.FileService;
import br.glacks.service.HashService;
import br.glacks.service.PessoaFisicaService;
import br.glacks.service.UsuarioLogadoService;
import br.glacks.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {

    public static final Logger LOG = Logger.getLogger(UsuarioLogadoServiceImpl.class);

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    UsuarioService usuarioService;

    @Inject
    PessoaFisicaService pessoaFisicaService;

    @Inject
    UsuarioRepository repository;

    @Inject
    PessoaFisicaRepository pessoaFisicaRepository;

    @Inject
    FileService fileService;
    
    @Inject
    HashService hash;

    @Inject
    TelefoneRepository telefoneRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public UsuarioResponseDTO updateSenha(UsuarioUpdateSenhaDTO senha) {
        try {
            LOG.info(getPerfilUsuarioLogado().id().toString() + " - Requisição Usuario.updateSenha() ");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());

            if(hash.getHashSenha(senha.senhaAnterior()) != entity.getSenha())
                throw new NotFoundException("Senha anterior Incorreta");

            entity.setSenha(hash.getHashSenha(senha.novaSenha()));
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição Usuario.updateSenha()");
            return null;
        }

    }

    @Override
    public Response enderecos() {
        try {
            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());
            return Response.ok(entity.getEnderecos().stream().filter(EntityClass::getAtivo).map(EnderecoResponseDTO::new).collect(Collectors.toList())).build();

        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login) {
        try {
            LOG.info(getPerfilUsuarioLogado().id().toString() + " - Requisição Usuario.updateLogin()");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());
            if(hash.getHashSenha(login.senha()) != entity.getSenha())
                throw new NotFoundException("Senha Incorreta");
            
            entity.setLogin(login.login());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição Usuario.updateLogin()");
            return null;
        }

    }
    @Override
    @Transactional
    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome) {
        try {
            LOG.info(getPerfilUsuarioLogado().id().toString() + " - Requisição Usuario.updateNome()");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());
            if(entity instanceof PessoaFisica){
                if(hash.getHashSenha(nome.senha()) != entity.getSenha())
                    throw new NotFoundException("Senha Incorreta");
            PessoaFisica p = pessoaFisicaRepository.findById(entity.getId());
            p.setNome(nome.nome());
            }
            
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição Usuario.updateNome()");
            return null;
        }

    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email) {
        try {
            LOG.info(getPerfilUsuarioLogado().id().toString() + " - Requisição UsuarioLogado.updateEmail()");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());
            if(hash.getHashSenha(email.senha()) != entity.getSenha())
                throw new NotFoundException("Senha Incorreta");
            
            entity.setEmail(email.email());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error(getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição UsuarioLogado.updateEmail()");
            return null;
        }

    }

    @Override
    public Response getGostei() {
        try {
            LOG.info(getPerfilUsuarioLogado().id().toString() + " - Requisição UsuarioLogado.getGostei()");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());

            return Response.ok(entity.getGostei().stream().map(ProdutoResponseDTO::new).collect(Collectors.toList())).build();
        } catch (Exception e) {
            LOG.error(getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição UsuarioLogado.getGostei()");
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response gosteiInsert(long id) {
        try {
                LOG.info(getPerfilUsuarioLogado().id().toString() + " - Requisição UsuarioLogado.gosteiInsert()");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());

            Produto p = produtoRepository.findById(id);
            if(entity.getGostei().isEmpty())
                entity.setGostei(new ArrayList<>());

            entity.getGostei().add(p);

            return Response.ok(entity.getGostei().stream().filter(EntityClass::getAtivo).map(ProdutoResponseDTO::new).collect(Collectors.toList())).build();
        } catch (Exception e) {
            LOG.error(getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição UsuarioLogado.gosteiInsert()");
            return Response.status(400).entity(e.getMessage()).build();
                }
    }

    @Override
    @Transactional
    public Response gosteiDelete(Long id) {
        try {
            LOG.info(getPerfilUsuarioLogado().id().toString() + " - Requisição UsuarioLogado.gosteiDelete()");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());
            Produto p = produtoRepository.findById(id);
            entity.getGostei().remove(p);

            return Response.ok(entity.getGostei().stream().filter(EntityClass::getAtivo).map(ProdutoResponseDTO::new).collect(Collectors.toList())).build();
        } catch (Exception e) {
            LOG.error(getPerfilUsuarioLogado().id().toString() + " - Erro ao rodar Requisição UsuarioLogado.gosteiDelete()");
            return Response.status(400).entity(e.getMessage()).build();
        }
    }


    @Override
    public UsuarioResponseDTO getPerfilUsuarioLogado() {

        try {
            LOG.info("Requisição UsuarioLogado.getPerfilUsuarioLogado()");

            String login = jsonWebToken.getSubject();
            UsuarioResponseDTO user = usuarioService.findByLogin(login);

            return user;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição UsuarioLogado.getPerfilUsuarioLogado()");
            return null;
        }

    }

    @Override
    public PessoaFisicaResponseDTO getPerfilPessoaFisicaLogado() {

        try {
            LOG.info("Requisição UsuarioLogado.getPerfilUsuarioLogado()");

            String login = jsonWebToken.getSubject();
            UsuarioResponseDTO user = usuarioService.findByLogin(login);
            PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(user.id());
            return new PessoaFisicaResponseDTO(pessoaFisica);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição UsuarioLogado.getPerfilUsuarioLogado()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response deleteOn() {
        try {
            LOG.info("Requisição UsuarioLogado.delete()");

            Usuario entity = repository.findById(getPerfilUsuarioLogado().id());
            entity.setAtivo(false);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição UsuarioLogado.delete()");
            return null;
        }
    }

    @Override
    @Transactional
    public Response salvarImagem(@MultipartForm ImageForm form) {
        String nomeImagem = "";

        try {
            nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNome());
            // obtendo o login a partir do token
            String login = jsonWebToken.getSubject();
            UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

            usuario = usuarioService.updateImagem(usuario.id(), nomeImagem);

            LOG.info("Requisição UsuarioLogado.salvarImagem()");

            return Response.ok(usuario).build();
        } catch (IOException e) {
            Result result = new Result(e.getMessage());

            LOG.error("Erro ao rodar Requisição UsuarioLogado.salvarImagem()");

            return Response.status(400).entity(result).build();
        }

    }

    @Override
    public Response baixarImagem(@PathParam("nomeImagem") String nomeImagem) {

        try {
            LOG.info("Requisição UsuarioLogado.baixarImagem()");

            ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
            response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
            return response.build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição UsuarioLogado.baixarImagem()");
            return null;
        }

    }

    @Override
    public Response telefoneInsert(TelefoneUsuarioLogadoDTO telefoneUsuarioLogadoDTO) {
        try {
            Usuario usuariolUsuario = repository.findByLogin(jsonWebToken.getSubject());
            Telefone tell = new Telefone();
            tell.setAtivo(true);
            tell.setCodigoArea(telefoneUsuarioLogadoDTO.codigoArea());
            tell.setNumero(telefoneUsuarioLogadoDTO.numero());
            tell.setProprietario(usuariolUsuario);
            
            if(usuariolUsuario.getTelefones() == null){
                List<Telefone> telefones = new ArrayList<Telefone>();
                telefones.add(tell);
                usuariolUsuario.setTelefones(telefones);
            }else{
                usuariolUsuario.getTelefones().add(tell);
            }
            return Response.ok(new TelefoneResponseDTO(tell)).build();
        } catch (Exception e) {
            return Response.status(400).entity(e).build();
        }
    }

    @Transactional
    @Override
    public Response insertEndereco(EnderecoDTO endereco) {
        try {
            Usuario usuariolUsuario = repository.findByLogin(jsonWebToken.getSubject());
            LOG.info("Requisição UsuarioLogado.insertEndereco()");
            Endereco e = EnderecoDTO.criaEndereco(endereco);
            e.setCidade(cidadeRepository.findById(endereco.idCidade()));
            e.setUsuario(usuariolUsuario);
            enderecoRepository.persist(e);
            return Response.ok(new EnderecoResponseDTO(e)).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição UsuarioLogado.insertEndereco()");
            return Response.status(400).build();
        }

    }
}
