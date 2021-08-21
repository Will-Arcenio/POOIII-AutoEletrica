
package model;

import Abstratas.Base;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Base implements java.io.Serializable{
    @Column(name = "CPF", length = 18, nullable = false)
    @SwingColumn(description = "CPF")
    private String cpf;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CIDADE", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Cidade")
    private Cidade cidade;
    
    @Column(name = "ENDERECO", length = 150, nullable = false)
    @SwingColumn(description = "Endereço")
    private String endereco;
    
    @Column(name = "TELEFONE", length = 18, nullable = false)
    @SwingColumn(description = "Telefone")
    private String telefone;
    
    @Column(name = "EMAIL", length = 100)
    @SwingColumn(description = "E-mail")
    private String email;
    
    //
    public Cliente() {
        super();        
        this.setCpf("00000000000");
        this.setCidade(null);
        this.setEndereco("Endereço Padrão");
        this.setTelefone("48900000000");
        this.setEmail("email@teste.com.br");
    }
    
    public Cliente(int id, String nome, String cpf, Cidade cidade, String endereco, String telefone, String email) {
        super(id, nome);
        this.setCpf(cpf);
        this.setCidade(cidade);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setEmail(email);
    }
    
    //
    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ? "00000000000" : cpf;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = (cidade == null) ? new Cidade() : cidade;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty() ? "Endereço Padrão" : endereco.toUpperCase();
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty() ? "48900000000" : telefone;
    }
    public void setEmail(String email) {
        this.email = email.trim().isEmpty() ? "email@teste.com.br" : email.toLowerCase();
    }
    
    //
    public String getCpf() {
        return this.cpf;
    }
    
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public String getEmail() {
        return this.email;
    }
}
