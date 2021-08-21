
package model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServico implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VEICULO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Veículo")
    private Veiculo veiculo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FUNCIONARIO", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Funcionário")
    private Funcionario funcionario;
    
    @Column(name = "VALOR", nullable = false, scale = 2)
    @SwingColumn(description = "Valor")
    private double valor;
    
    @Column(name = "DESCONTO", scale = 2)
    @SwingColumn(description = "Desconto")
    private double desconto;
    
    @Column(name = "VALOR_FINAL", nullable = false, scale = 2)
    @SwingColumn(description = "Valor Final")
    private double valorFinal;
    
    @Column(name = "PAGO", nullable = false)
    private boolean pago;
    
    @Column(name = "DATA_ENTRADA", nullable = false)
    @SwingColumn(description = "Data Entrada")
    private LocalDate dataEntrada;
    
    @Column(name = "DATA_SAIDA")
    @SwingColumn(description = "Data Saída")
    private LocalDate dataSaida;
    
    //
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "ordemServico")
    private List<ItemProduto> listProduto;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ordemServico")
    private List<ItemServico> listServico;
    
    //

    public OrdemServico() {
        this.setId(0);
        this.setVeiculo(null);
        this.setFuncionario(null);
        this.setValor(0.01);
        this.setDesconto(0.01);
        this.setValorFinal(0.01);
        this.setPago(false);
        this.setDataEntrada(null);
        this.setDataSaida(null);
    }
    
    public OrdemServico(int id, Veiculo veiculo, Funcionario funcionario, double valor, double desconto, double valorFinal, boolean pago, LocalDate dataEntrada, LocalDate dataSaida) {
        this.setId(id);
        this.setVeiculo(veiculo);
        this.setFuncionario(funcionario);
        this.setValor(valor);
        this.setDesconto(desconto);
        this.setValorFinal(valorFinal);
        this.setPago(pago);
        this.setDataEntrada(dataEntrada);
        this.setDataSaida(dataSaida);
    }
    
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo == null ? new Veiculo() : veiculo;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario == null ? new Funcionario() : funcionario;
    }

    public void setListProduto(List<ItemProduto> listProduto) {
        this.listProduto = listProduto;
    }

    public void setListServico(List<ItemServico> listServico) {
        this.listServico = listServico;
    }

    public void setValor(double valor) {
        this.valor = valor <= 0 ? 1.01 : valor;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal <= 0 ? 0.01 : valorFinal;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada == null ? LocalDate.now() : dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    //
    public int getId() {
        return this.id;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public double getValor() {
        return this.valor;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public double getValorFinal() {
        return this.valorFinal;
    }

    public boolean isPago() {
        return this.pago;
    }

    public LocalDate getDataEntrada() {
        return this.dataEntrada;
    }

    public LocalDate getDataSaida() {
        return this.dataSaida;
    }
    
    //
    public List<ItemProduto> getListProduto() {
        return this.listProduto;
    }

    public List<ItemServico> getListServico() {
        return this.listServico;
    }
    
    //
    @Override
    public String toString() {
        return this.id + "";
    }
    
    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final OrdemServico other = (OrdemServico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
