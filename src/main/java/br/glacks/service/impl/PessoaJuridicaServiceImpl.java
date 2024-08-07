package br.glacks.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.EntityClass;
import br.glacks.repository.UsuarioRepository;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.PessoaJuridicaResponseDTO;
import br.glacks.dto.UsuarioDTO;
import br.glacks.model.Perfil;
import br.glacks.model.PessoaJuridica;
import br.glacks.model.Usuario;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.service.HashService;
import br.glacks.service.PessoaJuridicaService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

    public static final Logger LOG = Logger.getLogger(PessoaJuridicaServiceImpl.class);

    @Inject
    PessoaJuridicaRepository repository;

    @Inject
    HashService hash;

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    public List<PessoaJuridicaResponseDTO> getAll() {

        try {
            LOG.info("Requisição PessoaFisica.getAll()");
            return repository.findAll()
                    .stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId))
                    .map(PessoaJuridicaResponseDTO::new)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getAll()");
            return null;
        }

    }

    @Override
    public Response getId(long id) {
        try {
            LOG.info("Requisição PessoaFisica.getId()");

            return Response.ok(new PessoaJuridicaResponseDTO(repository.findById(id))).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getId()");
            return Response.status(400).build();
        }

    }

    @Override
    public List<PessoaJuridicaResponseDTO> getNome(String nome) {
        try {
            LOG.info("Requisição PessoaFisica.getNome()");

            return repository.findByNome(nome)
                    .stream()
                    .map(PessoaJuridicaResponseDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getNome()");
            return null;
        }

    }

    @Override
    public List<PessoaJuridicaResponseDTO> getCnpj(String cnpj) {
        try {
            LOG.info("Requisição PessoaFisica.getCnpj()");

            return repository.findByCnpj(cnpj)
                    .stream()
                    .sorted(Comparator.comparing(EntityClass::getId).reversed())
                    .map(pessoaJuridica -> new PessoaJuridicaResponseDTO(pessoaJuridica))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getCnpj()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(PessoaJuridicaDTO pessoaJuridicaDTO) {
        try {
            LOG.info("Requisição PessoaJuridica.insert()");
            PessoaJuridica pj = PessoaJuridicaDTO.criaPessoaJuridica(pessoaJuridicaDTO);
            Usuario u = usuarioRepository.findByLogin(pessoaJuridicaDTO.usuarioDTO().login());
            if(u != null){
                throw new Exception("Login ja existe!");
            }
            pj.getPerfis().add(Perfil.USER);
            pj.setSenha(hash.getHashSenha(pj.getSenha()));
            repository.persist(pj);
            return Response.ok(pj).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Usuario.insert() " + e.getMessage());
            return Response.notModified().build();
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

    @Override
    public PessoaJuridicaResponseDTO update(long id, PessoaJuridicaDTO pessoajuridica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
