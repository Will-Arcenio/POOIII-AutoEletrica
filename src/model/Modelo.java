
package model;

import Abstratas.Base;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MODELO")
public class Modelo extends Base implements java.io.Serializable{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MARCA", nullable = false, referencedColumnName = "ID")
    private Marca marca;
    
    public Modelo() {
        super();
        this.setMarca(null);
    }
    
    public Modelo(int id, String nome, Marca marca) {
        super(id, nome);
        this.setMarca(marca);
    }
    
    //
    public void setMarca(Marca marca) {
        this.marca = marca == null ? new Marca() : marca;
    }
    
    //
    public Marca getMarca() {
        return this.marca;
    }
    
    //
    @Override
    public String toString() {
        return this.marca + " - " + super.getNome();
    }
}
