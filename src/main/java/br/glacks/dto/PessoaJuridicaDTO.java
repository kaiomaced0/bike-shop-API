package br.glacks.dto;

import org.hibernate.validator.constraints.br.CNPJ;

import br.glacks.model.PessoaJuridica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PessoaJuridicaDTO(
    @Size(min = 2, max = 50)
    @NotBlank
    String nomeFantasia,
    @CNPJ
    @NotBlank
    String cnpj,
    String razaoSocial,
    UsuarioDTO usuarioDTO
) {

    public static PessoaJuridica criaPessoaJuridica(PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNomeFantasia(pessoaJuridicaDTO.nomeFantasia());
        pj.setLogin(pessoaJuridicaDTO.usuarioDTO.login());
        pj.setSenha(pessoaJuridicaDTO.usuarioDTO.senha());
        pj.setEmail(pessoaJuridicaDTO.usuarioDTO.email());
        pj.setCnpj(pessoaJuridicaDTO.cnpj());
        pj.setRazaoSocial(pessoaJuridicaDTO.razaoSocial());
        
        return pj;
    }
    
}
