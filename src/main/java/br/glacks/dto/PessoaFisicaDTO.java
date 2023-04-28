package br.glacks.dto;

import br.glacks.model.PessoaFisica;

public record PessoaFisicaDTO(
    UsuarioDTO usuarioDTO,
    String cpf

) {

    public static PessoaFisica criaPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome(pessoaFisicaDTO.usuarioDTO.nome());
        pessoaFisica.setLogin(pessoaFisicaDTO.usuarioDTO.login());
        pessoaFisica.setEmail(pessoaFisicaDTO.usuarioDTO.email());
        pessoaFisica.setSenha(pessoaFisicaDTO.usuarioDTO.senha());
        pessoaFisica.setCpf(pessoaFisicaDTO.cpf);

        return pessoaFisica;
    }
}
