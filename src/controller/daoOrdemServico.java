
package controller;

import Abstratas.dao;
import java.util.List;
import model.Cliente;
import model.OrdemServico;

public class daoOrdemServico extends dao<OrdemServico>{
    
    public List<OrdemServico> read() {
        return super.read("select os from OrdemServico os order by os.id");
    }
    
    public List<OrdemServico> read(Cliente cliente) {
        return super.read("select os from OrdemServico os where os.veiculo.cliente.id like ?1 order by os.dataEntrada", cliente.getId());
    }
    
}
