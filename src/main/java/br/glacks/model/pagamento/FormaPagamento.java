package br.glacks.model.pagamento;

import javax.persistence.Entity;

@Entity
public enum FormaPagamento {
    CARTAO, PIX, BOLETO, CARTAOCREDITO;

}

