
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_PRODUTO")
public class ItemProduto implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ORDEMSERVICO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Ordem Serviço")
    private OrdemServico ordemServico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUTO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Produto")
    private Produto produto;
    
    @Column(name = "QUANTIDADE", nullable = false, scale = 2)
    @SwingColumn(description = "Quantidade")
    private double quantidade;
    
    @Column(name = "VALOR", nullable = false, scale = 2)
    @SwingColumn(description = "Valor")
    private double valor;
    
    //
    public ItemProduto() {
        this.setId(0);
        this.setOrdemServico(null);
        this.setProduto(null);
        this.setQuantidade(0.01);
        this.setValor(0.01);
    }
    
    public ItemProduto(int id, OrdemServico ordemServico, Produto produto, double quantidade, double valor) {
        this.setId(id);
        this.setOrdemServico(ordemServico);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
        this.setValor(valor);
    }
    
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public void setProduto(Produto produto) {
        this.produto = produto == null ? new Produto() : produto;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade <= 0 ? 0.01 : quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor <= 0 ? 0.01 : valor;
    }
    
    //
    public int getId() {
        return this.id;
    }

    public OrdemServico getOrdemServico() {
        return this.ordemServico;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public double getQuantidade() {
        return this.quantidade;
    }

    public double getValor() {
        return this.valor;
    }
    
    //
    @Override
    public String toString() {
        return this.produto + " [OS: " + this.ordemServico + "] ";
    }
    
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemProduto other = (ItemProduto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
