package br.glacks.dto;

import br.glacks.model.Endereco;

public record EnderecoResponseDTO(
    Long id,
    Long idUsuario,
    CidadeResponseDTO cidade,
    String cep,
    String rua,
    String numero,
    String descricao
) {
    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getId(),endereco.getUsuario().getId(),
        new CidadeResponseDTO(endereco.getCidade().getId(), endereco.getCidade().getNome(), new EstadoResponseDTO(endereco.getCidade().getEstado().getId(), endereco.getCidade().getEstado().getNome())), endereco.getCep(), endereco.getRua(), endereco.getNumero(),
        endereco.getDescricao());
    }
    
}
