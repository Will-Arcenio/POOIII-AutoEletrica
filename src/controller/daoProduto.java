
package controller;

import Abstratas.dao;
import java.util.List;
import model.Fornecedor;
import model.Modelo;
import model.Produto;

public class daoProduto extends dao<Produto>{
    
    public List<Produto> read() {
        return super.read("select p from Produto p order by p.nome");
    }
    
    public List<Produto> read(String filtro) {
        return super.read("select p from Produto p where p.referencia like ?1 order by p.nome", "%" + filtro.toUpperCase() + "%");
    }
    
    public List<Produto> read(Fornecedor fornecedor) {
        return super.read("select p from Produto p where p.fornecedor like ?1 order by p.nome", "%" + fornecedor + "%");
    }
    
    public List<Produto> read(Modelo modelo) {
        return super.read("select p from Produto p where p.modelo like ?1 order by p.nome", "%" + modelo + "%");
    }
    
}
