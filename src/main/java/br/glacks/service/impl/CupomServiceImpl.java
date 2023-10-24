package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.CupomDTO;
import br.glacks.dto.CupomResponseDTO;
import br.glacks.model.Cupom;
import br.glacks.repository.CupomRepository;
import br.glacks.service.CupomService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

    public static final Logger LOG = Logger.getLogger(CupomServiceImpl.class);

    @Inject
    CupomRepository repository;

    @Override
    public List<CupomResponseDTO> getAll() {
        try {
            LOG.info("Requisição Cupom.getAll()");
            return repository.findAll().stream().map(CupomResponseDTO::new).collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getAll()");
            return null;
        }

    }

    @Override
    public CupomResponseDTO getId(long id) {
        try {
            LOG.info("Requisição Cupom.getId()");
            return new CupomResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getId()");
            return null;
        }

    }

    @Override
    public List<CupomResponseDTO> getNome(String nome) {
        try {
            LOG.info("Requisição Cupom.getNome()");
            return repository.findByNome(nome).stream().map(CupomResponseDTO::new).collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getNome()");
            return null;
        }

    }

    @Override
    public CupomResponseDTO getCodigo(String codigo) {
        try {
            LOG.info("Requisição Cupom.getCodigo()");
            return new CupomResponseDTO(repository.findByCodigo(codigo));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.getCodigo()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(CupomDTO cupom) {
        try {
            LOG.info("Requisição Cupom.insert()");
            repository.persist(CupomDTO.criaCupom(cupom));
            return Response.ok(cupom).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.insert()");
            return Response.status(Status.NOT_IMPLEMENTED).build();
        }

    }

    @Override
    @Transactional
    public Response update(long id, CupomDTO cupom) {
        try {
            LOG.info("Requisição Cupom.update()");
            Cupom entity = repository.findById(id);
            entity.setNome(cupom.nome());
            entity.setCodigo(cupom.codigo());
            entity.setQuantidade(cupom.quantidade());
            entity.setValorDesconto(cupom.valorDesconto());
            return Response.accepted(new CupomResponseDTO(entity)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.update()");
            return Response.status(Status.NO_CONTENT).build();
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Cupom.delete()");
            Cupom entity = repository.findById(id);
            entity.setAtivo(false);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Cupom.delete()");
            return Response.status(Status.NO_CONTENT).build();
        }

    }

}
