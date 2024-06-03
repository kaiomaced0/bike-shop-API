package br.glacks.dto;

import br.glacks.model.PessoaFisica;

import java.util.List;
import java.util.stream.Collectors;

public record PessoaFisicaResponseDTO(
    String cpf,
    Long id,
    String login,
    String nome,
    String email,
    List<CartaoResponseDTO> cartoes,
    List<EnderecoResponseDTO> enderecos,
    List<ProdutoResponseDTO> listaGostei,
    List<String> telefones
) {
    
    public PessoaFisicaResponseDTO(PessoaFisica user){
      this(user.getCpf(),
              user.getId(),
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
