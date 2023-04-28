package br.glacks.dto;

import br.glacks.model.PessoaJuridica;

public record PessoaJuridicaDTO(
    UsuarioDTO usuarioDTO,
    String cnpj
) {

    public static PessoaJuridica criaPessoaJuridica(PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome(pessoaJuridicaDTO.usuarioDTO.nome());
        pj.setLogin(pessoaJuridicaDTO.usuarioDTO.login());
        pj.setSenha(pessoaJuridicaDTO.usuarioDTO.senha());
        pj.setEmail(pessoaJuridicaDTO.usuarioDTO.email());
        pj.setCnpj(pessoaJuridicaDTO.cnpj);
        
        return pj;
    }
    
}
