package br.glacks.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import br.glacks.model.PessoaFisica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PessoaFisicaDTO(
    @CPF
    @NotBlank
            @Size(max = 11, min = 11)
    String cpf,

    @NotBlank
    @Size(min = 2, max = 50)
    String nome,
    @NotBlank
    @Size(min = 3, max = 25)
    String login,
    @NotBlank
    @Size(min = 3, max = 1000)
    String senha,
    @NotBlank
    @Email
    String email,
    LocalDate dataNascimento

) {

    public static PessoaFisica criaPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setLogin(pessoaFisicaDTO.login());
        pessoaFisica.setEmail(pessoaFisicaDTO.email());
        pessoaFisica.setSenha(pessoaFisicaDTO.senha());
        pessoaFisica.setCpf(pessoaFisicaDTO.cpf);
        pessoaFisica.setNome(pessoaFisicaDTO.nome());
        if(pessoaFisicaDTO.dataNascimento != null){
            pessoaFisica.setDataNascimento(pessoaFisicaDTO.dataNascimento());
        }

        return pessoaFisica;
    }
}
