
package controller;

import Abstratas.dao;
import java.sql.SQLException;
import java.util.List;
import model.Veiculo;

public class daoVeiculo extends dao<Veiculo>{
    
    public List<Veiculo> read(int id) {
        return super.read("select v from Veiculo v where id = ?1", id);
    }
    
    public List<Veiculo> read(){
        return super.read("select v from Veiculo v order by v.modelo");
    }
    
    //
    public List<Veiculo> readModelo(String filtro){
        //String SQL = "SELECT *, modelo.nome FROM veiculo INNER JOIN modelo ON veiculo.modelo = modelo.id WHERE modelo.nome LIKE ? ORDER BY modelo.nome";
        return super.read("select v from Veiculo v where v.modelo.nome like ?1 order by v.modelo.nome", "%" + filtro.toUpperCase() + "%");
    }
    
    public List<Veiculo> readCliente(String filtro) {
        //String SQL = "SELECT *, cliente.nome FROM veiculo INNER JOIN cliente ON veiculo.cliente = cliente.id WHERE cliente.nome LIKE ? ORDER BY cliente.nome";
        return super.read("select v from Veiculo v where v.cliente.nome like ?1 order by v.cliente.nome", "%" + filtro.toUpperCase() + "%");
    }
    
}
