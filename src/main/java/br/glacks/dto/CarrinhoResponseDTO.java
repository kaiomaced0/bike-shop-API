package br.glacks.dto;

import java.util.HashMap;
import java.util.Map;

import br.glacks.model.Carrinho;
import br.glacks.model.ListaProduto;

public class CarrinhoResponseDTO {
    private String nome;
    private Long id;
    private Map<String, Object> usuario;
    private Map<String, Object> produtos;

    public CarrinhoResponseDTO(Carrinho carrinho){
        this.nome = carrinho.getNome();
        this.id = carrinho.getId();
        this.usuario = new HashMap<String, Object>();
        usuario.put("Id", carrinho.getUsuario().getNome());
        usuario.put("Nome", carrinho.getUsuario().getNome());
        this.produtos = new HashMap<String, Object>();
        for (ListaProduto listaProduto : carrinho.getlistaProdutos()) {
            produtos.put("Quantidade", listaProduto.getQuantidade());
            produtos.put("Id", listaProduto.getProduto().getId());
            produtos.put("Nome", listaProduto.getProduto().getNome());
        }
        
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
    public Map<String, Object> getProdutos() {
        return produtos;
    }
    public void setProdutos(Map<String, Object> produtos) {
        this.produtos = produtos;
    }

    

    
}
