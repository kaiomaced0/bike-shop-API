package br.glacks.service;

import br.glacks.model.Usuario;

public interface TokenJwtSerice {
    public String generateJwt(Usuario usuario);
}
