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
    List<ProdutoResponseDTO> listaGostei
) {
    
    public PessoaFisicaResponseDTO(PessoaFisica pessoaFisica){
      this(pessoaFisica.getCpf(), pessoaFisica.getId(),
              pessoaFisica.getLogin(),
              pessoaFisica.getNome(),
              pessoaFisica.getEmail(),
              pessoaFisica.getCartoes() != null ? pessoaFisica.getCartoes()
                      .stream()
                      .map(CartaoResponseDTO::new)
                      .collect(Collectors.toList()) : null,
              pessoaFisica.getEnderecos() != null ? pessoaFisica.getEnderecos()
                      .stream()
                      .map(EnderecoResponseDTO::new)
                      .collect(Collectors.toList()): null,
              pessoaFisica.getGostei() != null ? pessoaFisica.getGostei()
                      .stream()
                      .map(ProdutoResponseDTO::new)
                      .collect(Collectors.toList()): null);
    }
}
