package br.glacks.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import br.glacks.model.Perfil;
import br.glacks.model.Usuario;
import br.glacks.service.TokenJwtService;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenJwtServiceImpl implements TokenJwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    public static final Logger LOG = Logger.getLogger(TelefoneServiceImpl.class);

    @Override
    public String generateJwt(Usuario usuario) {

        try {
            Instant now = Instant.now();

            Instant expiryDate = now.plus(EXPIRATION_TIME);

            Set<String> roles = usuario.getPerfis()
                    .stream().map(p -> p.getLabel())
                    .collect(Collectors.toSet());

            LOG.info("Requisição TokenJwt.generateJwt()");

            return Jwt.issuer("unitins-jwt")
                    .subject(usuario.getLogin())
                    .groups(roles)
                    .expiresAt(expiryDate)
                    .sign();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição TokenJwt.generateJwt()");
            return null;
        }

    }

    @Override
    public String generateJwtJuridico(Usuario usuario) {

        try {
            Instant now = Instant.now();

            Instant expiryDate = now.plus(EXPIRATION_TIME);

            String roles = Perfil.USER_CNPJ.getLabel();

            LOG.info("Requisição TokenJwt.generateJwt()");

            return Jwt.issuer("unitins-jwt")
                    .subject(usuario.getLogin())
                    .groups(roles)
                    .expiresAt(expiryDate)
                    .sign();

        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição TokenJwt.generateJwt()");
            return null;
        }

    }

}
