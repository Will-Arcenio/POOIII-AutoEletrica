
package controller;

import Abstratas.dao;
import java.util.List;
import model.Cliente;

public class daoCliente extends dao<Cliente>{
    
    public List<Cliente> read() {
        return super.read("select c from Cliente c order by c.nome");
    }
    
    public List<Cliente> read(int id) {
        return super.read("select c from Cliente c where c.id = ?1", id);
    }
    
    public List<Cliente> read(String filtro) {
        return super.read("select c from Cliente c where c.nome like ?1 order by c.nome", "%" + filtro.toUpperCase() + "%");
    }
    
}
