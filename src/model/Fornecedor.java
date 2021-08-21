
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
@Table(name = "FORNECEDOR")
public class Fornecedor extends Base implements java.io.Serializable{
    @Column(name = "CNPJ", length = 22, nullable = false)
    @SwingColumn(description = "Cnpj")
    private String cnpj;
    
    @Column(name = "ENDERECO", length = 150, nullable = false)
    @SwingColumn(description = "Endereço")
    private String endereco;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", nullable = false, referencedColumnName = "ID")
    @SwingColumn(description = "Cidade")
    private Cidade cidade;
    
    @Column(name = "TELEFONE", length = 18, nullable = false)
    @SwingColumn(description = "Telefone")
    private String telefone;
    
    @Column(name = "NOME_CONTATO", length = 150)
    @SwingColumn(description = "Nome Contato")
    private String nomeContato;
    
    @Column(name = "EMAIL", length = 100)
    @SwingColumn(description = "E-mail")
    private String email;
    
    @Column(name = "SITE", length = 100)
    @SwingColumn(description = "Site")
    private String site;
    
    //CONSTRUCTORS
    public Fornecedor() {
        super();
        this.setCnpj("00.000.000/0000-00");
        this.setEndereco("ENDEREÇO PADRÃO");
        this.setCidade(null);
        this.setTelefone("(48)99999-9999");
        this.setNomeContato("CONTATO PADRÃO");
        this.setEmail("email@teste.com.br");
        this.setSite("sitepadrão.com.br");
    }

    public Fornecedor(int id, String nome, String cnpj, String endereco, Cidade cidade, String telefone, String nomeContato, String email, String site) {
        super(id, nome);
        this.setCnpj(cnpj);
        this.setEndereco(endereco);
        this.setCidade(cidade);
        this.setTelefone(telefone);
        this.setNomeContato(nomeContato);
        this.setEmail(email);
        this.setSite(site);
    }
    
    //SETTERS
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj.trim().isEmpty() ? "00.000.000/0000-00" : cnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty() ? "ENDEREÇO PADRÃO" : endereco.toUpperCase();
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade == null ? new Cidade() : cidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty() ?"(48)99999-9999" : telefone;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato.toUpperCase();
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public void setSite(String site) {
        this.site = site.toLowerCase();
    }
    
    //GETTERS
    public String getCnpj() {
        return this.cnpj;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getNomeContato() {
        return this.nomeContato;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSite() {
        return this.site;
    }
    
    //
    public String toString() {
        return super.getNome() + "\t | \t" + this.getTelefone();
    }
}
