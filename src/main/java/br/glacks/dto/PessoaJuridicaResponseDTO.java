package br.glacks.dto;

import br.glacks.model.PessoaJuridica;

public record PessoaJuridicaResponseDTO(
    UsuarioResponseDTO usuarioResponseDTO,
    String cnpj
) {
    public PessoaJuridicaResponseDTO (PessoaJuridica pessoaJuridica){
        this(new UsuarioResponseDTO(pessoaJuridica), pessoaJuridica.getCnpj());
    }
    
}
