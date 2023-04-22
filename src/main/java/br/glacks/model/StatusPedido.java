package br.glacks.model;

public enum StatusPedido {
    PREPARANDO(1, "Preparando"), EM_ROTA(2, "Em rota"), ENTREGUE(3, "Entregue"), FINALIZADO(4, "Finalizado"), CANCELADO(5, "Cancelado");

    private int id;
    private String label;

    StatusPedido(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static StatusPedido valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(StatusPedido statuspedido : StatusPedido.values()) {
            if (id.equals(statuspedido.getId()))
                return statuspedido;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
