
package controller;

import Abstratas.dao;
import java.time.LocalDate;
import java.util.List;
import model.ItemServico;
import model.OrdemServico;
import model.Servico;

public class daoItemServico extends dao<ItemServico>{
    
    public List<ItemServico> read() {
        return super.read("select its from ItemServico its order by its.ordemServico");
    }
    
    public List<ItemServico> read(Servico servico, LocalDate data) {
        return super.read("select its from ItemServico its where its.servico like ?1 and its.ordemServico.datEntrada >= ?2 order by its.ordemServico", servico, data);
    }
    
    public List<ItemServico> read(OrdemServico ordemServico) {
        return super.read("select its from ItemServico its where its.ordemServico = ?1 order by its.id", ordemServico);
    }
    
}
