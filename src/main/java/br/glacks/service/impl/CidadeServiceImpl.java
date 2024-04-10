package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.dto.CidadeResponseDTO;
import br.glacks.model.EntityClass;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.CidadeDTO;
import br.glacks.model.locais.Cidade;
import br.glacks.repository.CidadeRepository;
import br.glacks.repository.EstadoRepository;
import br.glacks.service.CidadeService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {
    @Inject
    CidadeRepository repository;

    @Inject
    EstadoRepository estadoRepository;

    private static final Logger LOG = Logger.getLogger(CidadeServiceImpl.class);

    @Override
    public Response getAll() {
        try {
            LOG.info("Requisição Cidade.getAll()");
            return Response.ok(repository.findAll().stream().filter(EntityClass::getAtivo).map(CidadeResponseDTO::new).collect(Collectors.toList())).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cidade.getAll()");
            return null;
        }

    }

    @Override
    public Response getId(long id) {
        try {
            LOG.info("Requisição Cidade.getId()");

            return Response.ok(new CidadeResponseDTO(repository.findById(id))).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cidade.getId()");
            return null;
        }

    }

    @Override
    public Response getNome(String nome) {
        try {
            LOG.info("Requisição Cidade.getNome()");
            return Response.ok(repository.findByNome(nome)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cidade.getNome()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(CidadeDTO cidade) {
        try {
            LOG.info("Requisição Cidade.insert()");
            Cidade c = new Cidade();
            c.setNome(cidade.nome());
            c.setEstado(estadoRepository.findById(cidade.estadoId().longValue()));
            repository.persist(c);
            return Response.ok(cidade).build();
        } catch (Exception e) {

            LOG.error("Erro ao rodar Requisição Cidade.insert()");
            return null;
        }
    }

    @Override
    @Transactional
    public Cidade update(long id, CidadeDTO cidade) {
        try {
            LOG.info("Requisição Cidade.update()");

            Cidade entity = repository.findById(id);
            entity.setNome(cidade.nome());
            return entity;
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cidade.update()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Cidade.delete()");
            Cidade entity = repository.findById(id);
            entity.setAtivo(false);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cidade.delete()");
            return null;
        }

    }

}
