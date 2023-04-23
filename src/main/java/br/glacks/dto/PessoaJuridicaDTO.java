package br.glacks.dto;

public record PessoaJuridicaDTO(
    UsuarioDTO usuarioDTO,
    String cnpj
) {
    
}
