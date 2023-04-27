package br.glacks.dto;

import br.glacks.model.PessoaFisica;

public record PessoaFisicaResponseDTO(
    UsuarioResponseDTO usuarioResponseDTO,
    String cpf
) {
    
    public PessoaFisicaResponseDTO(PessoaFisica pessoaFisica){
      this(new UsuarioResponseDTO(pessoaFisica.getId(), pessoaFisica.getNome(), pessoaFisica.getLogin()), pessoaFisica.getCpf());
    }
}
