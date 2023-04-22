package br.glacks.dto;

import br.glacks.model.PessoaJuridica;

public record PessoaJuridicaDTO(
    UsuarioDTO usuarioDTO,
    String cnpj
) {
    
}
