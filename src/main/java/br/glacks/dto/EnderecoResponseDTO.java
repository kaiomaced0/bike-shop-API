package br.glacks.dto;

import br.glacks.model.Endereco;

public record EnderecoResponseDTO(
    Long id,
    Long idUsuario,
    String nome,
    CidadeResponseDTO cidade,
    String cep,
    String rua,
    String numero,
    String descricao
) {
    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getId(),endereco.getUsuario().getId(),
                endereco.getNome(),
        new CidadeResponseDTO(endereco.getCidade().getId(),
                endereco.getCidade().getNome(),
                endereco.getCidade().getEstado().getNome()),
                endereco.getCep(),
                endereco.getRua(),
                endereco.getNumero(),
        endereco.getDescricao());
    }
    
}
