package br.glacks.dto;

import org.hibernate.validator.constraints.br.CPF;

import br.glacks.model.PessoaFisica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PessoaFisicaDTO(
    @NotBlank
    @Size(min = 2, max = 50)
    String nome,
    @CPF
    @NotBlank
    String cpf,
    UsuarioDTO usuarioDTO

) {

    public static PessoaFisica criaPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome(pessoaFisicaDTO.nome());
        pessoaFisica.setLogin(pessoaFisicaDTO.usuarioDTO.login());
        pessoaFisica.setEmail(pessoaFisicaDTO.usuarioDTO.email());
        pessoaFisica.setSenha(pessoaFisicaDTO.usuarioDTO.senha());
        pessoaFisica.setCpf(pessoaFisicaDTO.cpf);

        return pessoaFisica;
    }
}
