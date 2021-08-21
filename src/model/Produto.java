
package model;

import Abstratas.Base;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto extends Base implements java.io.Serializable{
    @Column(name = "REFERENCIA", nullable = false, length = 50)
    @SwingColumn(description = "Referência")
    private String referencia;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODELO", nullable = false, referencedColumnName = "ID")
    private Modelo modelo;
    
    @Column(name = "NOVO", nullable = false)
    private boolean novo;
    
    @Column(name = "QUANTIDADE", nullable = false, scale = 3)
    @SwingColumn(description = "Quantidade")
    private double quantidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FORNECEDOR", nullable = false, referencedColumnName = "ID")
    private Fornecedor fornecedor;
    
    @Column(name = "VALOR_COMPRA", nullable = false, scale = 3)
    @SwingColumn(description = "Valor Compra")
    private double valorCompra;
    
    @Column(name = "VALOR_VENDA", nullable = false, scale = 3)
    @SwingColumn(description = "Valor Venda")
    private double valorVenda;
    
    //
    public Produto() {
        super();
        this.setReferencia("000000000");
        this.setModelo(null);
        this.setNovo(true);
        this.setQuantidade(1);
        this.setFornecedor(null);
        this.setValorCompra(0.01);
        this.setValorVenda(0.01);
    }
    
    public Produto(int id, String nome, String referencia, Modelo modelo, boolean novo, double quantidade, Fornecedor fornecedor, double valorCompra, double valorVenda) {
        super(id, nome);
        this.setReferencia(referencia);
        this.setModelo(modelo);
        this.setNovo(novo);
        this.setQuantidade(quantidade);
        this.setFornecedor(fornecedor);
        this.setValorCompra(valorCompra);
        this.setValorVenda(valorVenda);
    }
    
    //
    public void setReferencia(String referencia) {
        this.referencia = referencia.trim().isEmpty() ? "000000000" : referencia.toUpperCase();
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo == null ? new Modelo() : modelo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade < 0 ? 0 : quantidade;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor == null ? new Fornecedor() : fornecedor;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra <= 0 ? 0.01 : valorCompra;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda <= 0 ? 0.01 : valorVenda;
    }
    
    //
    public String getReferencia() {
        return this.referencia;
    }

    public Modelo getModelo() {
        return this.modelo;
    }

    public boolean isNovo() {
        return this.novo;
    }

    public double getQuantidade() {
        return this.quantidade;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public double getValorCompra() {
        return this.valorCompra;
    }

    public double getValorVenda() {
        return this.valorVenda;
    }
    
    //
    @Override
    public String toString() {
        return "[" + this.getReferencia() + "] " + super.getNome();
    }
}
