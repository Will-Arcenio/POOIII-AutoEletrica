
package model;

import Abstratas.Base;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCAO")
public class Funcao extends Base implements java.io.Serializable{

    //
    public Funcao() {
        super();
    }

    public Funcao(int id, String nome) {
        super(id, nome);
    }
}
