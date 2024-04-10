package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.EntityClass;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.AvaliacaoDTO;
import br.glacks.dto.AvaliacaoResponseDTO;
import br.glacks.model.Avaliacao;
import br.glacks.repository.AvaliacaoRepository;
import br.glacks.repository.ProdutoRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.AvaliacaoService;
import br.glacks.service.UsuarioLogadoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvaliacaoServiceImpl implements AvaliacaoService {

    public static final Logger LOG = Logger.getLogger(AvaliacaoServiceImpl.class);

    @Inject
    AvaliacaoRepository repository;

    @Inject
    UsuarioRepository uRepository;

    @Inject
    ProdutoRepository pRepository;

    @Inject
    UsuarioLogadoService usuarioLogado;

    @Override
    public Response getAll() {
        try {
            LOG.info("Requisição Avaliacao.getAll() - " + repository.count() + " itens.");
            return Response.ok(repository.findAll()
            .stream().filter(EntityClass::getAtivo)
            .map(AvaliacaoResponseDTO::new)
            .collect(Collectors.toList())).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Avaliacao.getAll()");
            return null;

        }
    }

    @Override
    public Response getId(long id) {
        try {

            LOG.info("Requisição Avaliacao.getId()");
            return Response.ok(new AvaliacaoResponseDTO(repository.findById(id))).build();

        } catch (Exception e) {

            LOG.error("Erro ao rodar Requisição Avaliacao.getId()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(AvaliacaoDTO avaliacao) {
        try {
            Avaliacao a = AvaliacaoDTO.criAvaliacao(avaliacao);
            if (uRepository.findById(a.getUsuario().getId()) == null) {
                a.setUsuario(uRepository.findById(usuarioLogado.getPerfilUsuarioLogado().id()));
            }
            if (pRepository.findById(a.getProduto().getId()) != null) {
                a.setProduto(pRepository.findById(a.getProduto().getId()));
            }
            repository.persist(a);
            LOG.info("Requisição Avaliacao.insert()");
            return Response.ok(new AvaliacaoResponseDTO(a)).build();
        } catch (Exception e) {

            LOG.error("Erro ao rodar Requisição Avaliacao.insert()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response update(long id, AvaliacaoDTO avaliacao) {
        try {
            
            Avaliacao entity = repository.findById(id);
            entity.setEstrela(avaliacao.estrela());
            entity.setComentario(avaliacao.comentario());
            LOG.info("Requisição Avaliacao.update()");
            return Response.ok(new AvaliacaoResponseDTO(entity)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Avaliacao.update()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Avaliacao.delete()");
            Avaliacao entity = repository.findById(id);
        entity.setAtivo(false);

        return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Avaliacao.delete()");
            return Response.status(Status.NOT_IMPLEMENTED).build();
        }
        
    }

}
