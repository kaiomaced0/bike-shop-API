package br.glacks.dto;

import java.util.HashMap;
import java.util.Map;

import br.glacks.model.Pedido;

public class PedidoResponseDTO {
    private String nome;
    private Long id;
    private Map<String, Object> usuario;

    public PedidoResponseDTO(Pedido pedido){
        this.nome = pedido.getNome();
        this.id = pedido.getId();
        this.usuario = new HashMap<String, Object>();
        this.usuario.put("Id", pedido.getCompra().getUsuario().getId());
        this.usuario.put("nome", pedido.getCompra().getUsuario().getNome());
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Map<String, Object> getUsuario() {
        return usuario;
    }
    public void setUsuario(Map<String, Object> usuario) {
        this.usuario = usuario;
    }

    
    
}
