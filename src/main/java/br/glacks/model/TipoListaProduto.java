package br.glacks.model;

public enum TipoListaProduto {
    
    CARRINHO(1, "Carrinho"),
    PEDIDO(2, "Pedido"),
    LISTA_DESEJO(31, "Lista de Desejo"),
    ESTOQUE(4, "Estoque");

    private int id;
    private String label;

    TipoListaProduto(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoListaProduto valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(TipoListaProduto tipoListaProduto : TipoListaProduto.values()) {
            if (id.equals(tipoListaProduto.getId()))
                return tipoListaProduto;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
