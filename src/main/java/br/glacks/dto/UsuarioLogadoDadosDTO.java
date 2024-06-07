package br.glacks.dto;

public record UsuarioLogadoDadosDTO(
        PessoaFisicaDTO pessoa,
        String senhaAtual
) {
}
