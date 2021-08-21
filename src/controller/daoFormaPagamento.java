
package controller;

import Abstratas.dao;
import java.util.List;
import model.FormaPagamento;

public class daoFormaPagamento extends dao<FormaPagamento>{
    
    public List<FormaPagamento> read() {
        return super.read("select fp from FormaPagamento fp order by fp.nome");
    }
    
    public List<FormaPagamento> read(String filtro) {
        return super.read("select fp from FormaPagamento fp where fp.nome like ?1 order by fp.nome", "%" + filtro.toUpperCase() + "%");
    }
    
}
