package br.glacks.model.pagamento;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.glacks.model.EntityClass;
import br.glacks.model.Usuario;

@Entity
public class Cartao extends EntityClass{

    @ManyToOne
    private Usuario usuario;

    private String numero;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    
}
