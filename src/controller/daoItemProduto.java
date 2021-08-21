
package controller;

import Abstratas.dao;
import java.time.LocalDate;
import java.util.List;
import model.ItemProduto;
import model.OrdemServico;
import model.Produto;

public class daoItemProduto extends dao<ItemProduto>{
    
    public List<ItemProduto> read() {
        return super.read("select ip from ItemProduto ip order by ip.ordemServico");
    }
    
    public List<ItemProduto> read(Produto produto, LocalDate data) {
        return super.read("select ip from ItemProduto ip where ip.produto like ?1 and ip.ordemServico.datEntrada >= ?2 order by ip.ordemServico", produto, data);
    }
    
    public List<ItemProduto> read(OrdemServico ordemServico) {
        return super.read("select ip from ItemProduto ip where ip.ordemServico = ?1 order by ip.id", ordemServico);
    }
    
}
