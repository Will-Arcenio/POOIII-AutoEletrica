
package model;

import Abstratas.Base;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICO")
public class Servico extends Base implements java.io.Serializable{
    @Column(name = "PRECO", nullable = false, scale = 2)
    private double preco;
    
    @Column(name = "TEMPO", nullable = false)
    private int tempo;
    
    //
    public Servico() {
        super();
        this.setPreco(0.01);
        this.setTempo(0);
    }
    
    public Servico(int id, String nome, double preco, int tempo) {
        super(id, nome);
        this.setPreco(preco);
        this.setTempo(tempo);
    }
    
    //
    public void setPreco(double preco) {
        this.preco = preco <= 0 ? 0.01 : preco;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo <= 0 ? 1 : tempo;
    }
    
    //
    public double getPreco() {
        return this.preco;
    }
    
    public int getTempo() {
        return this.tempo;
    }
    
    //
    @Override
    public String toString() {
        return super.getNome();
    }
}
