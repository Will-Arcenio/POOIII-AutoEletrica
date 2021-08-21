
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
@Table(name = "VEICULO")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODELO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Modelo")
    private Modelo modelo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENTE", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Cliente")
    private Cliente cliente;
    
    @Column(name = "ANO", nullable = false, length = 4)
    @SwingColumn(description = "Ano")
    private String ano;
    
    @Column(name = "PLACA", nullable = false, length = 8)
    @SwingColumn(description = "Placa")
    private String placa;
    
    @Column(name = "HODOMETRO", nullable = false, length = 6)
    @SwingColumn(description = "Hodômetro")
    private String hodometro;
    
    //
    public Veiculo() {
        this.setId(0);
        this.setModelo(null);
        this.setCliente(null);
        this.setAno("2021");
        this.setPlaca("PLA1234");
        this.setHodometro("0");
    }
    
    public Veiculo(int id, Modelo modelo, Cliente cliente, String ano, String placa, String hodometro) {
        this.setId(id);
        this.setModelo(modelo);
        this.setCliente(cliente);
        this.setAno(ano);
        this.setPlaca(placa);
        this.setHodometro(hodometro);
    }
    
    //
    public void setId(int id) {
        this.id = id;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = (modelo == null) ? new Modelo() : modelo;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = (cliente == null) ? new Cliente() : cliente;
    }
    
    public void setAno(String ano) {
        this.ano = ano.trim().isEmpty() ? "2021" : ano;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa.trim().isEmpty() ? "PLA1234" : placa.toUpperCase();
    }
    public void setHodometro(String hodometro) {
        this.hodometro = hodometro.trim().isEmpty() ? "0" : hodometro;
    }
    
    //
    public int getId() {
        return this.id;
    }
    
    public Modelo getModelo() {
        return this.modelo;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public String getAno() {
        return this.ano;
    }
    
    public String getPlaca() {
        return this.placa;
    }
    
    public String getHodometro() {
        return this.hodometro;
    }
    
    //
    @Override
    public String toString() {
        return this.modelo.getMarca() + " - " + this.modelo.getNome() + " (" + this.placa + ") " + " [PROPRIETÁRIO: " + this.getCliente() + "] ";
    }
    
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final Veiculo other = (Veiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
