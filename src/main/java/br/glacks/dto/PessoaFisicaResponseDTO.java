package br.glacks.dto;

import br.glacks.model.PessoaFisica;

public record PessoaFisicaResponseDTO(
    String cpf,
    UsuarioResponseDTO usuarioResponseDTO
) {
    
    public PessoaFisicaResponseDTO(PessoaFisica pessoaFisica){
      this(pessoaFisica.getCpf(), new UsuarioResponseDTO(pessoaFisica));
    }
}
