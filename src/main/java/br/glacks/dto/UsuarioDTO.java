package br.glacks.dto;

import br.glacks.model.Usuario;

public record UsuarioDTO(
    String nome,
    String login,
    String senha,
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
