package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Endereco;
import br.glacks.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String login,
        String email,
        List<CartaoResponseDTO> cartoes,
        List<EnderecoResponseDTO> enderecos,
        List<ProdutoResponseDTO> listaGostei

) {
    public UsuarioResponseDTO(Usuario user) {
        this(user.getId(),
                user.getNome(),
                user.getLogin(),
                user.getEmail(),
                user.getCartoes()
                        .stream()
                        .map(cartao -> new CartaoResponseDTO(cartao))
                        .collect(Collectors.toList()),
                user.getEnderecos()
                        .stream()
                        .map(endereco -> new EnderecoResponseDTO(endereco))
                        .collect(Collectors.toList()),
                user.getGostei()
                        .stream()
                        .map(produto -> new ProdutoResponseDTO(produto))
                        .collect(Collectors.toList()));

    }
}
