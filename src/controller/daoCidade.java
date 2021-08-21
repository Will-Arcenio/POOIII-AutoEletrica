
package controller;

import Abstratas.dao;
import enums.Estados;
import java.util.List;
import model.Cidade;

public class daoCidade extends dao<Cidade> {
    
    public List<Cidade> read(int id)  {
        return super.read("select c from Cidade c where c.id = ?1", id);
    }
    
    public List<Cidade> read() {
        return super.read("select c from Cidade c ORDER BY c.nome");
    }
    
    public List<Cidade> read(String filtro) {
        return super.read("select c from Cidade c where c.nome like ?1 order by c.nome", "%" + filtro.toUpperCase() + "%");
    }
    
    public List<Cidade> read(Estados estado) {
        return super.read("select c from Cidade c where c.estado like ?1 order by c.estado", "%" + estado + "%");
    }
    
}
