
package model;

import Abstratas.Base;
import enums.Estados;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "CIDADE")
public class Cidade extends Base implements java.io.Serializable{
    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", length = 2, nullable = false)
    @SwingColumn(description = "Estado")
    private Estados estado;
    
    //
    public Cidade() {
        super();
        this.setEstado(Estados.SC);
    }
    
    public Cidade(int id, String nome, Estados estado) {
        super(id, nome);
        this.setEstado(estado);
    }
    
    //
    public void setEstado(Estados estado) {
        this.estado = estado;
    }
    
    //
    public Estados getEstado() {
        return this.estado;
    }
    
    //
    @Override
    public String toString() {
        return this.getNome() + " - " + this.estado.name();
    }
}
