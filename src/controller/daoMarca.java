
package controller;

import Abstratas.dao;
import model.Marca;
import java.util.List;

public class daoMarca extends dao<Marca> {
    
    public List<Marca> read(int id) {
        return super.read("select m from Marca m where m.id = ?1", id);
    }
    
    public List<Marca> read() {
        return super.read("select m from Marca m order by m.nome");
    }
    
    public List<Marca> read(String filtro) {
        return super.read("select m from Marca m where m.nome like ?1 order by m.nome", "%" + filtro.toUpperCase() + "%");
    }
    
}
