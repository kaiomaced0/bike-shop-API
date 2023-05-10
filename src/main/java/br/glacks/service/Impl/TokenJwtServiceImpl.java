package br.glacks.service.Impl;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import br.glacks.model.Usuario;
import br.glacks.service.TokenJwtSerice;
import io.smallrye.jwt.build.Jwt;

public class TokenJwtServiceImpl implements TokenJwtSerice{
    

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);
    
    @Override
    public String generateJwt(Usuario usuario) {
        Instant now = Instant.now();

        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = usuario.getPerfis()
                                        .stream().map(p -> p.getLabel())
                                        .collect(Collectors.toSet());
        return Jwt.issuer("unitins-jwt")
            .subject(usuario.getLogin())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }
    
}
