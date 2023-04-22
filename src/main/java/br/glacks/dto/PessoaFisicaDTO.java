package br.glacks.dto;

import br.glacks.model.PessoaFisica;
import br.glacks.model.Usuario;

public record PessoaFisicaDTO(
    UsuarioDTO usuarioDTO,
    String cpf

) {
   
}
