
package controller;

import Abstratas.dao;
import java.util.List;
import model.Cidade;
import model.Funcao;
import model.Funcionario;

public class daoFuncionario extends dao<Funcionario>{
    
    public List<Funcionario> read() {
        return super.read("select f from Funcionario f order by f.nome");
    }
    
    public List<Funcionario> read(String filtro) {
        return super.read("select f from Funcionario f where f.nome like ?1 order by f.nome", "%" + filtro.toUpperCase() + "%");
    }
    
    public List<Funcionario> read(Funcao funcao) {
        return super.read("select f from Funcionario f where f.funcao.nome like ?1 order by f.nome", "%" + funcao.getNome() + "%");
    }
    
    public List<Funcionario> read(Cidade cidade) {
        return super.read("select f from Funcionario f where f.cidade.nome like ?1 order by f.nome", "%" + cidade.getNome() + "%");
    }
    
}
