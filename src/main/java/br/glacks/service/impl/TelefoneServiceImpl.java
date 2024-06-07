package br.glacks.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.EntityClass;
import org.eclipse.microprofile.jwt.JsonWebToken;
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

    @Inject
    JsonWebToken jsonWebToken;


    @Override
    public List<TelefoneResponseDTO> getAll() {
        
        try {
            LOG.info("Requisição Telefone.getAll()");

            return repository.findAll().stream().filter(EntityClass::getAtivo)
                    .sorted(Comparator.comparing(EntityClass::getId).reversed())
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
            String login = jsonWebToken.getSubject();
            Usuario user = usuarioRepository.findByLogin(login);
            LOG.info("Requisição Telefone.insert()");
            Telefone tell = new Telefone();
            tell.setCodigoArea(telefone.codigoArea());
            tell.setNumero(telefone.numero());
            tell.setProprietario(user);
            if(user.getTelefones().isEmpty()){
                user.setGostei(new ArrayList<>());
            }
            repository.persist(tell);
            user.getTelefones().add(tell);
            return Response.ok(telefone).build();
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.insert()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    @Override
    @Transactional
    public TelefoneResponseDTO update(long id, TelefoneDTO telefone) {
        try {
            String login = jsonWebToken.getSubject();
            Usuario user = usuarioRepository.findByLogin(login);
            LOG.info("Requisição Telefone.update()");

            Telefone entity = repository.findById(id);

            if(entity.getProprietario() != user)
                throw new Exception();
            if(telefone.numero() != null)
                entity.setNumero(telefone.numero());
            if(telefone.codigoArea() != null)
                entity.setCodigoArea(telefone.codigoArea());

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
            String login = jsonWebToken.getSubject();
            Usuario user = usuarioRepository.findByLogin(login);
            LOG.info("Requisição Telefone.delete()");
            
            Telefone entity = repository.findById(id);
            if(entity.getProprietario() != user){
                throw new Exception("Telefone não pertence a voce");
            }
            entity.setAtivo(false);
            return Response.status(Status.OK).build();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição Telefone.delete()");
            return Response.status(400).entity(e.getMessage()).build();
        }

    }

    

}
