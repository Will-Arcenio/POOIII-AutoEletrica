package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Modelo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-20T18:00:22", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, Cliente> cliente;
    public static volatile SingularAttribute<Veiculo, String> ano;
    public static volatile SingularAttribute<Veiculo, Integer> id;
    public static volatile SingularAttribute<Veiculo, Modelo> modelo;
    public static volatile SingularAttribute<Veiculo, String> placa;
    public static volatile SingularAttribute<Veiculo, String> hodometro;

}