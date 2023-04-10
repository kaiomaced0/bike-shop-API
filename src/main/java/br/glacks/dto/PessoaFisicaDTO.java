package br.glacks.dto;

import br.glacks.model.PessoaFisica;
import br.glacks.model.Usuario;

public class PessoaFisicaDTO {
    private UsuarioDTO usuarioDTO;
    private String cpf;

    public static PessoaFisica criaPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO){
        Usuario pessoa = UsuarioDTO.criaUsuario(pessoaFisicaDTO.getUsuarioDTO());
        PessoaFisica pessoaJ = (PessoaFisica) pessoa;
        pessoaJ.setCpf(pessoaFisicaDTO.getCpf());
        return pessoaJ;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }
    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
