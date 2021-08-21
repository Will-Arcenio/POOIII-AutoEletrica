package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.OrdemServico;
import model.Servico;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-20T18:00:22", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ItemServico.class)
public class ItemServico_ { 

    public static volatile SingularAttribute<ItemServico, Double> valor;
    public static volatile SingularAttribute<ItemServico, Integer> id;
    public static volatile SingularAttribute<ItemServico, OrdemServico> ordemServico;
    public static volatile SingularAttribute<ItemServico, Servico> servico;

}