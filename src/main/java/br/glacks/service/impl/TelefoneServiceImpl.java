package br.glacks.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.EntityClass;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.glacks.dto.TelefoneDTO;
import br.glacks.dto.TelefoneResponseDTO;
import br.glacks.model.Telefone;
import br.glacks.model.Usuario;
import br.glacks.repository.TelefoneRepository;
import br.glacks.repository.UsuarioRepository;
import br.glacks.service.TelefoneService;
import br.glacks.service.UsuarioLogadoService;
import br.glacks.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {

    public static final Logger LOG = Logger.getLogger(TelefoneServiceImpl.class);

    @Inject
    TelefoneRepository repository;

    @Inject
    UsuarioLogadoService usuarioLogadoService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    public List<TelefoneResponseDTO> getAll() {
        
        try {
            LOG.info("Requisição Telefone.getAll()");

            return repository.findAll().stream().filter(EntityClass::getAtivo)
                    .map(TelefoneResponseDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getAll()");
            return null;
        }

    }

    @Override
    public TelefoneResponseDTO getId(long id) {
        try {
            LOG.info("Requisição Telefone.getId()");

            return new TelefoneResponseDTO(repository.findById(id));
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.getId()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response insert(TelefoneDTO telefone) {
        try {
            LOG.info("Requisição Telefone.insert()");
            Telefone tell = new Telefone();
            tell.setCodigoArea(telefone.codigoArea());
            tell.setNumero(telefone.numero());
            tell.setProprietario(usuarioRepository.findById(telefone.proprietarioId().longValue()));
            Usuario u = usuarioRepository.findById(telefone.proprietarioId().longValue());
            if(u.getTelefones() == null){
                List<Telefone> telefones = new ArrayList<Telefone>();
                telefones.add(tell);
                u.setTelefones(telefones);
            }else{
                u.getTelefones().add(tell);
            }
            repository.persist(tell);
            return Response.ok(telefone).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.insert()");
            return null;
        }

    }

    @Override
    @Transactional
    public TelefoneResponseDTO update(long id, TelefoneDTO telefone) {
        try {
            LOG.info("Requisição Telefone.update()");

            Telefone entity = repository.findById(id);
            if(telefone.numero() != null)
                entity.setNumero(telefone.numero());
            if(telefone.codigoArea() != null)
                entity.setCodigoArea(telefone.codigoArea());
            if(telefone.proprietarioId() != null)
                entity.setProprietario(usuarioRepository.findById(telefone.proprietarioId().longValue()));
            
            return new TelefoneResponseDTO(entity);
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.update()");
            return null;
        }

    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            LOG.info("Requisição Telefone.delete()");
            
            Telefone entity = repository.findById(id);
            if(entity.getProprietario().getLogin() != usuarioLogadoService.getPerfilUsuarioLogado().login()){

            throw new Exception("Telefone não pertence a voce");
            }
            entity.setAtivo(false);
            return Response.status(Status.OK).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.delete()");
            return null;
        }

    }

    

}
