package br.glacks.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.PessoaJuridicaResponseDTO;
import br.glacks.model.PessoaJuridica;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.service.PessoaJuridicaService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

    public static final Logger LOG = Logger.getLogger(PessoaJuridicaServiceImpl.class);

    @Inject
    PessoaJuridicaRepository repository;

    @Override
    public List<PessoaJuridicaResponseDTO> getAll() {

        try {
            LOG.info("Requisição PessoaFisica.getAll()");
            return repository.findAll()
                    .stream()
                    .sorted(Comparator.comparing(pessoaJuridica -> pessoaJuridica.getId()))
                    .map(pessoaJuridica -> new PessoaJuridicaResponseDTO(pessoaJuridica))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getAll()");
            return null;
        }

    }

    @Override
    public PessoaJuridica getId(long id) {
        try {
            LOG.info("Requisição PessoaFisica.getId()");

            return repository.findById(id);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getId()");
            return null;
        }

    }

    @Override
    public List<PessoaJuridicaResponseDTO> getNome(String nome) {
        try {
            LOG.info("Requisição PessoaFisica.getNome()");

            return repository.findByNome(nome)
                    .stream()
                    .map(pessoaJuridica -> new PessoaJuridicaResponseDTO(pessoaJuridica))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getNome()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(PessoaJuridicaDTO pessoaJuridicaDTO) {
        try {
            LOG.info("Requisição PessoaFisica.insert()");

            PessoaJuridica pessoaJuridica = PessoaJuridicaDTO.criaPessoaJuridica(pessoaJuridicaDTO);
            if (pessoaJuridicaDTO == null) {
                throw new Exception("pessoajuridica nula");
            }
            repository.persist(pessoaJuridica);
            return Response.ok(new PessoaJuridicaResponseDTO(pessoaJuridica)).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.insert()");
            return Response.status(Status.NOT_IMPLEMENTED).build();
        }

    }

    @Override
    @Transactional
    public PessoaJuridicaResponseDTO update(long id, PessoaJuridicaDTO pessoaJuridica) {
        try {
            LOG.info("Requisição PessoaFisica.update()");

            PessoaJuridica entity = repository.findById(id);
            if (pessoaJuridica.usuarioDTO().login() != null) {
                entity.setLogin(pessoaJuridica.usuarioDTO().login());
            }
            if (pessoaJuridica.usuarioDTO().nome() != null) {
                entity.setNome(pessoaJuridica.usuarioDTO().nome());
            }
            if (pessoaJuridica.usuarioDTO().senha() != null) {
                entity.setSenha(pessoaJuridica.usuarioDTO().senha());
            }
            if (pessoaJuridica.cnpj() != null) {
                entity.setCnpj(pessoaJuridica.cnpj());
            }
            return new PessoaJuridicaResponseDTO(entity);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.update()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição PessoaFisica.delete()");

            PessoaJuridica entity = repository.findById(id);
            entity.setAtivo(false);

            return Response.status(Status.OK).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.delete()");
            return null;
        }

    }

}
