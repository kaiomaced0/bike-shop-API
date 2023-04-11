package br.glacks.dto;

import br.glacks.model.PessoaJuridica;

public class PessoaJuridicaDTO {
    private UsuarioDTO usuarioDTO;
    private String cnpj;

    public static PessoaJuridica criaPessoaJuridica(PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridica pessoaJ = new PessoaJuridica();
        pessoaJ.setNome(pessoaJuridicaDTO.getUsuarioDTO().getNome());
        pessoaJ.setLogin(pessoaJuridicaDTO.getUsuarioDTO().getLogin());
        pessoaJ.setSenha(pessoaJuridicaDTO.getUsuarioDTO().getSenha());
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
