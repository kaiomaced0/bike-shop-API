package br.glacks.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.EnderecoDTO;
import br.glacks.dto.UsuarioResponseDTO;
import br.glacks.model.Usuario;
import br.glacks.model.locais.Cidade;
import br.glacks.repository.CidadeRepository;
import br.glacks.repository.UsuarioRepository;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;
import br.glacks.repository.EnderecoRepository;
import br.glacks.service.EnderecoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    public static final Logger LOG = Logger.getLogger(EnderecoServiceImpl.class);

    @Inject
    EnderecoRepository repository;

    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    public List<EnderecoResponseDTO> getAll() {
        try {
            LOG.info("Requisição endereco.getAll()");
            return repository.findAll()
                    .stream()
                    .map(EnderecoResponseDTO::new)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.getAll()");
            return null;
        }

    }

    @Override
    public EnderecoResponseDTO getId(long id) {
        try {
            LOG.info("Requisição endereco.getId()");

            return new EnderecoResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.getId()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(EnderecoDTO endereco) {
        try {

            String login = jsonWebToken.getSubject();
            Usuario user = usuarioRepository.findByLogin(login);

            LOG.info("Requisição endereco.insert()");
            Endereco e = EnderecoDTO.criaEndereco(endereco);
            Cidade c = cidadeRepository.findById(endereco.idCidade());
            e.setCidade(c);
            repository.persist(e);
            if(user.getEnderecos().isEmpty()){
                user.setEnderecos(new ArrayList<>());
            }
            user.getEnderecos().add(e);
            e.setUsuario(user);
            return Response.ok(new EnderecoResponseDTO(e)).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.insert()");
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @Override
    @Transactional
    public Response update(Long id, EnderecoDTO endereco) {
        try {

            String login = jsonWebToken.getSubject();
            Usuario user = usuarioRepository.findByLogin(login);

            LOG.info("Requisição endereco.update()");
            Endereco e = repository.findById(id.longValue());
            if(e.getUsuario().getId() != user.getId()){
                throw new Exception("Você nao é o proprietario desse endereco");
            }
            Cidade c = cidadeRepository.findById(endereco.idCidade());

            e.setNome(endereco.nome());
            e.setCep(endereco.cep());
            e.setRua(endereco.rua());
            e.setNumero(endereco.numero());
            e.setDescricao(endereco.descricao());
            e.setCidade(c);
            repository.persist(e);
            return Response.ok(new EnderecoResponseDTO(e)).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.update()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição endereco.delete()");

            Endereco entity = repository.findById(id);
            entity.setAtivo(false);
    
            return Response.status(Status.OK).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição endereco.delete()");
            return null;
        }

    }

}
