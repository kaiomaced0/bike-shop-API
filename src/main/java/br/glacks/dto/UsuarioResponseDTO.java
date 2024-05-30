package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String login,
        String nome,
        String email,
        List<CartaoResponseDTO> cartoes,
        List<EnderecoResponseDTO> enderecos,
        List<ProdutoResponseDTO> listaGostei,
        List<String> telefones

) {
    public UsuarioResponseDTO(Usuario user) {
        this(user.getId(),
                user.getLogin(),
                user.getNome(),
                user.getEmail(),
                user.getCartoes() != null ? user.getCartoes()
                .stream()
                        .map(CartaoResponseDTO::new)
                        .collect(Collectors.toList()) : null,
                user.getEnderecos() != null ? user.getEnderecos()
                .stream()
                        .map(EnderecoResponseDTO::new)
                        .collect(Collectors.toList()): null,
                user.getGostei() != null ? user.getGostei()
                .stream()
                        .map(ProdutoResponseDTO::new)
                        .collect(Collectors.toList()): null,
                user.getTelefones() != null ? user.getTelefones()
                        .stream()
                        .map(tell -> tell.getCodigoArea() + tell.getNumero())
                        .collect(Collectors.toList()): null);

    }
}
