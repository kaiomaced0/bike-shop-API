package br.glacks.dto;

import br.glacks.model.PessoaFisica;
import br.glacks.model.Usuario;

public class PessoaFisicaDTO {
    private UsuarioDTO usuarioDTO;
    private String cpf;

    public static PessoaFisica criaPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaF = new PessoaFisica();
        pessoaF.setNome(pessoaFisicaDTO.getUsuarioDTO().getNome());
        pessoaF.setLogin(pessoaFisicaDTO.getUsuarioDTO().getLogin());
        pessoaF.setSenha(pessoaFisicaDTO.getUsuarioDTO().getSenha());
        pessoaF.setCpf(pessoaFisicaDTO.getCpf());
        return pessoaF;
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
