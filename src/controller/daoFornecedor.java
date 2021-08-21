
package controller;

import Abstratas.dao;
import java.util.List;
import model.Cidade;
import model.Fornecedor;

public class daoFornecedor extends dao<Fornecedor> {

    public List<Fornecedor> read() {
        return super.read("select f from Fornecedor f order by f.nome");
    }
    
    public List<Fornecedor> read(String filtro) {
        return super.read("select f from Fornecedor f where f.nome like ?1 order by f.nome", "%" + filtro.toUpperCase() + "%");
    }
    
    public List<Fornecedor> read(Cidade cidade) {
        return super.read("select f from Fornecedor f where f.cidade.nome like ?1 order by f.cidade.nome", cidade);
    }
    
}
