
package controller;

import Abstratas.dao;
import java.sql.SQLException;
import java.util.List;
import model.Modelo;

public class daoModelo extends dao<Modelo>{
    
    public List<Modelo> read(){
        return super.read("select m from Modelo m order by m.nome");
    }
    
    public List<Modelo> read(String filtro) {
        return super.read("select m from Modelo m where m.nome like ?1 order by m.nome", "%" + filtro.toUpperCase() + "%");
    }
    
}
