package br.glacks.dto;

import java.util.List;

public record CompraDTO(
    List<ItemCompraResponseDTO> listaItemCompraResponseDTO,
    Double valorTotal,
    String token,
    String codigoRastreio,
    EnderecoResponseDTO enderecoEntrega


) {
    
}
