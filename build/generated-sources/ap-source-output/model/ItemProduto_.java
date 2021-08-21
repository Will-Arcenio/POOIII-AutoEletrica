package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.OrdemServico;
import model.Produto;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-20T18:00:23", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ItemProduto.class)
public class ItemProduto_ { 

    public static volatile SingularAttribute<ItemProduto, Produto> produto;
    public static volatile SingularAttribute<ItemProduto, Double> valor;
    public static volatile SingularAttribute<ItemProduto, Integer> id;
    public static volatile SingularAttribute<ItemProduto, OrdemServico> ordemServico;
    public static volatile SingularAttribute<ItemProduto, Double> quantidade;

}