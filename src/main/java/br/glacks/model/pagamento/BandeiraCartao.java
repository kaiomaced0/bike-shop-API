package br.glacks.model.pagamento;

public enum BandeiraCartao {
    
    MASTERCARD(1, "MasterCard"),
    VISA(2, "Visa"),
    ELO(31, "Elo"),
    AMERICANEXPRESS(4, "AmericanExpress"),
    MAESTRO(5, "Maestro");

    private int id;
    private String label;

    BandeiraCartao(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static BandeiraCartao valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(BandeiraCartao bandeira : BandeiraCartao.values()) {
            if (id.equals(bandeira.getId()))
                return bandeira;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
    
}
