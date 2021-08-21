
package model;

import Abstratas.Base;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends Base implements java.io.Serializable{
    @Column(name = "ENDERECO", nullable = false)
    private String endereco;
    
    @Column(name = "CPF", length = 18, nullable = false, unique = true)
    @SwingColumn(description = "CPF")
    private String cpf;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNCAO", nullable = false, referencedColumnName = "ID")
    private Funcao funcao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CIDADE", nullable = false, referencedColumnName = "ID")
    private Cidade cidade;
    
    @Column(name = "DATA_ADMISSAO", nullable = false)
    private LocalDate dataAdmissao;
    
    @Column(name = "TELEFONE", length = 18, nullable = false)
    private String telefone;
    
    @Column(name = "DATA_DEMISSAO")
    private LocalDate dataDemissao;
    
    //
    public Funcionario() {
        super();
        this.setEndereco("ENDEREÇO PADRÃO");
        this.setCpf("111.111.111-11");
        this.setFuncao(null);
        this.setCidade(null);
        this.setDataAdmissao(null);
        this.setTelefone("(48)91111-1111");
        this.setDataDemissao(null);
    }

    public Funcionario(int id, String nome, String endereco, String cpf, Funcao funcao, Cidade cidade, LocalDate dataAdmissao, String telefone, LocalDate dataDemissao) {
        super(id, nome);
        this.setEndereco(endereco);
        this.setCpf(cpf);
        this.setFuncao(funcao);
        this.setCidade(cidade);
        this.setDataAdmissao(dataAdmissao);
        this.setTelefone(telefone);
        this.setDataDemissao(dataDemissao);
        
    }
    
    //SETTERS
    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty() ? "ENDEREÇO PADRÃO" : endereco.toUpperCase();
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ? "111.111.111-11" : cpf;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao == null ? new Funcao() : funcao;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade == null ? new Cidade() : cidade;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao == null ? LocalDate.now() : dataAdmissao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty() ? "(48)91111-1111" : telefone;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
    
    //GETTERS
    public String getEndereco() {
        return this.endereco;
    }
    
    public String getCpf() {
        return this.cpf;
    }

    public Funcao getFuncao() {
        return this.funcao;
    }
    
    public Cidade getCidade() {
        return this.cidade;
    }

    public LocalDate getDataAdmissao() {
        return this.dataAdmissao;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public LocalDate getDataDemissao() {
        return this.dataDemissao;
    }
    
    //
    @Override
    public String toString() {
        return super.getNome();
    }
}
