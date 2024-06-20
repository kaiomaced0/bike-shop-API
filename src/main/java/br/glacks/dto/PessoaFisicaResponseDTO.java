package br.glacks.dto;

import br.glacks.model.PessoaFisica;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record PessoaFisicaResponseDTO(
    String cpf,
    Long id,
    String login,
    String nome,
    String email,
    LocalDate dataNascimento
) {
    
    public PessoaFisicaResponseDTO(PessoaFisica user){
      this(user.getCpf(),
              user.getId(),
              user.getLogin(),
              user.getNome(),
              user.getEmail(),
              user.getDataNascimento() != null ? user.getDataNascimento() : null);
    }
}
