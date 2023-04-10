package br.glacks.dto;

import br.glacks.model.PessoaJuridica;
import br.glacks.model.Usuario;

public class PessoaJuridicaDTO {
    private UsuarioDTO usuarioDTO;
    private String cnpj;

    public static PessoaJuridica criaPessoaJuridica(PessoaJuridicaDTO pessoaJuridicaDTO){
        Usuario pessoa = UsuarioDTO.criaUsuario(pessoaJuridicaDTO.getUsuarioDTO());
        PessoaJuridica pessoaJ = (PessoaJuridica) pessoa;
        pessoaJ.setCnpj(pessoaJuridicaDTO.getCnpj());
        return pessoaJ;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }
    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
