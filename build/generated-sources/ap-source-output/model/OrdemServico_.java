package model;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Funcionario;
import model.ItemProduto;
import model.ItemServico;
import model.Veiculo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-20T18:00:22", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(OrdemServico.class)
public class OrdemServico_ { 

    public static volatile SingularAttribute<OrdemServico, Veiculo> veiculo;
    public static volatile SingularAttribute<OrdemServico, Double> desconto;
    public static volatile SingularAttribute<OrdemServico, LocalDate> dataEntrada;
    public static volatile SingularAttribute<OrdemServico, Double> valor;
    public static volatile SingularAttribute<OrdemServico, Integer> id;
    public static volatile SingularAttribute<OrdemServico, Funcionario> funcionario;
    public static volatile SingularAttribute<OrdemServico, LocalDate> dataSaida;
    public static volatile ListAttribute<OrdemServico, ItemProduto> listProduto;
    public static volatile ListAttribute<OrdemServico, ItemServico> listServico;
    public static volatile SingularAttribute<OrdemServico, Double> valorFinal;
    public static volatile SingularAttribute<OrdemServico, Boolean> pago;

}