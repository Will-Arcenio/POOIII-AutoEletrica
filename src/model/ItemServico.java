
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
@Table(name = "ITEM_SERVICO")
public class ItemServico implements java.io.Serializable{
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
    @JoinColumn(name = "ID_SERVICO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Serviço")
    private Servico servico;
    
    @Column(name = "VALOR", nullable = false, scale = 2)
    @SwingColumn(description = "Valor")
    private double valor;
    
    //
    public ItemServico() {
        this.setId(0);
        this.setOrdemServico(null);
        this.setServico(null);
        this.setValor(0.01);
    }
    
    public ItemServico(int id, OrdemServico ordemServico, Servico servico, double valor) {
        this.setId(id);
        this.setOrdemServico(ordemServico);
        this.setServico(servico);
        this.setValor(valor);
    }
    
    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public void setServico(Servico servico) {
        this.servico = servico == null ? new Servico() : servico;
    }

    public void setValor(double valor) {
        this.valor = valor <= 0 ? 0.01 : valor;
    }
    
    //GETTERS
    public int getId() {
        return this.id;
    }

    public OrdemServico getOrdemServico() {
        return this.ordemServico;
    }

    public Servico getServico() {
        return this.servico;
    }

    public double getValor() {
        return this.valor;
    }

    //toString
    @Override
    public String toString() {
        return this.servico + " [OS: " + this.ordemServico + "] ";
    }
    
    //Equals e HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final ItemServico other = (ItemServico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
