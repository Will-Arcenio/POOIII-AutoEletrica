
package model;

import Abstratas.Base;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MARCA")
public class Marca extends Base implements java.io.Serializable{
    
    public Marca() {
        super();
    }
    
    public Marca(int id, String nome) {
        super(id, nome);
    }
}
