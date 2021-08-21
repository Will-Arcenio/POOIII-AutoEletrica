
package model;

import Abstratas.Base;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FORMA_PAGAMENTO")
public class FormaPagamento extends Base implements java.io.Serializable {
    @Column(name = "ABREVIACAO", nullable = false)
    private String abreviacao;
    
    //
    public FormaPagamento() {
        super();
        this.setAbreviacao("PADRÃO");
    }
    
    public FormaPagamento(int id, String nome, String abreviacao) {
        super(id, nome);
        this.setAbreviacao(abreviacao);
    }
    
    //
    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao.trim().isEmpty() ? "PADRÃO" : abreviacao.toUpperCase();
    }
    
    //
    public String getAbreviacao() {
        return this.abreviacao;
    }
    
    //
    @Override
    public String toString() {
        return super.getNome() + " - [" + this.getAbreviacao() + "]";
    }
}
