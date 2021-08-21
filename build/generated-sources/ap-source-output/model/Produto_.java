package model;

import Abstratas.Base_;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Fornecedor;
import model.Modelo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-20T18:00:23", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Produto.class)
public class Produto_ extends Base_ {

    public static volatile SingularAttribute<Produto, Double> valorVenda;
    public static volatile SingularAttribute<Produto, Double> valorCompra;
    public static volatile SingularAttribute<Produto, Boolean> novo;
    public static volatile SingularAttribute<Produto, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Produto, Modelo> modelo;
    public static volatile SingularAttribute<Produto, Double> quantidade;
    public static volatile SingularAttribute<Produto, String> referencia;

}