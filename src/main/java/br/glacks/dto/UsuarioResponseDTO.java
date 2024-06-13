package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.EntityClass;
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
                .stream().filter(EntityClass::getAtivo)
                        .map(CartaoResponseDTO::new)
                        .collect(Collectors.toList()) : null,
                user.getEnderecos() != null ? user.getEnderecos()
                .stream().filter(EntityClass::getAtivo)
                        .map(EnderecoResponseDTO::new)
                        .collect(Collectors.toList()): null,
                user.getGostei() != null ? user.getGostei()
                .stream().filter(EntityClass::getAtivo)
                        .map(ProdutoResponseDTO::new)
                        .collect(Collectors.toList()): null,
                user.getTelefones() != null ? user.getTelefones()
                        .stream().filter(EntityClass::getAtivo)
                        .map(tell -> tell.getCodigoArea() + tell.getNumero())
                        .collect(Collectors.toList()): null);

    }
}
