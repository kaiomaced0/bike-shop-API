package br.glacks.dto;

import br.glacks.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
    @NotBlank
    @Size(min = 3, max = 25)
    String login,
    @NotBlank
    @Size(min = 3, max = 1000)
    String senha,
    @NotBlank
    @Email
    String email
) {
    public static Usuario criaUsuario(UsuarioDTO usuarioDTO){
        Usuario user = new Usuario();
        user.setLogin(usuarioDTO.login);
        user.setEmail(usuarioDTO.email);
        user.setSenha(usuarioDTO.senha);
        return user;
    }
}
