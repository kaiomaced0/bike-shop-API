package br.glacks.model.pagamento;

public enum FormaPagamento {
    PIX(1, "Pix"), CARTAO_DEBITO(2, "Cartao Debito"), CARTAO_CREDITO(3, "Cartao Credido"), BOLETO(4, "Boleto");

    private int id;
    private String label;

    FormaPagamento(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static FormaPagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(FormaPagamento formapagamento : FormaPagamento.values()) {
            if (id.equals(formapagamento.getId()))
                return formapagamento;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}

