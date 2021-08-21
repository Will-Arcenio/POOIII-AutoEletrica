
package controller;

import Abstratas.dao;
import java.util.List;
import model.Funcao;

public class daoFuncao extends dao<Funcao>{
    
    public List<Funcao> read() {
        return super.read("select f from Funcao f order by f.nome");
    }
    
    public List<Funcao> read(String filtro) {
        return super.read("select f from Funcao f where f.nome like ?1 order by f.nome", "%" + filtro.toUpperCase() + "%");
    }
    
}
