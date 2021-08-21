
package Abstratas;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import model.SwingColumn;

@MappedSuperclass
abstract public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    protected int id;
    
    @Column(name = "NOME", length = 150, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    //
    public Base() {
        this.setId(0);
        this.setNome("PADRÃO");
    }
    
    public Base(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }
    
    //
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "PADRÃO" : nome.toUpperCase();
    }
    
    //
    public int getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    //
    @Override
    public String toString() {
        return this.nome;
    }
    
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
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
        final Base other = (Base) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
