package br.glacks.service;

import br.glacks.model.Usuario;

public interface TokenJwtService {
    public String generateJwt(Usuario usuario);

    public String generateJwtJuridico(Usuario usuario);
}
