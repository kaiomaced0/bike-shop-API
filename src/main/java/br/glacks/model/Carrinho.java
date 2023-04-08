package br.glacks.model;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carrinho extends EntityClass{
    
    @OneToMany
    private List<ListaProduto> listaProdutos;

    @ManyToOne
    private Cupom cupom;

    private Double valorCarrinho;

    @ManyToOne
    @JoinColumn(name = "usuario_carrinho")
    private Usuario usuario;

    
    public List<ListaProduto> getlistaProdutos() {
        return listaProdutos;
    }

    public void setlistaProdutos(List<ListaProduto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public Double getValorCarrinho() {
        return valorCarrinho;
    }

    public void setValorCarrinho(Double valorCarrinho) {
        this.valorCarrinho = valorCarrinho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    
    
}
