package br.glacks.dto;

import br.glacks.model.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
    @NotBlank
    String nome,
    @NotBlank
    String login,
    @NotBlank
    String senha,
    @NotBlank
    String email
) {
    public static Usuario criaUsuario(UsuarioDTO usuarioDTO){
        Usuario user = new Usuario();
        user.setNome(usuarioDTO.nome);
        user.setLogin(usuarioDTO.login);
        user.setEmail(usuarioDTO.email);
        user.setSenha(usuarioDTO.senha);
        return user;
    }
}
