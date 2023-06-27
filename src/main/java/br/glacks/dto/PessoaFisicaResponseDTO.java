package br.glacks.dto;

import br.glacks.model.PessoaFisica;

public record PessoaFisicaResponseDTO(
    String nome,
    String cpf,
    UsuarioResponseDTO usuarioResponseDTO
) {
    
    public PessoaFisicaResponseDTO(PessoaFisica pessoaFisica){
      this(pessoaFisica.getNome(), pessoaFisica.getCpf(), new UsuarioResponseDTO(pessoaFisica));
    }
}
