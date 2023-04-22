package br.glacks.model;

public enum Cor {
    VERMELHO(1, "Vermelho"),
    LARANJA(2, "Laranja"),
    AMARELO(3, "Amarelo"),
    VERDE(4, "Verde"),
    AZUL(5, "Azul"),
    ROXO(6, "Roxo"),
    ROSA(7, "Rosa"),
    PRETO(8, "Preto"),
    BRANCO(9, "Branco"),
    CINZA(10, "Cinza");

    private int id;
    private String label;

    Cor(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Cor valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(Cor cor : Cor.values()) {
            if (id.equals(cor.getId()))
                return cor;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
    
}
