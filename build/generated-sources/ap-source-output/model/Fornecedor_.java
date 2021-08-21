package model;

import Abstratas.Base_;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cidade;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-20T18:00:22", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ extends Base_ {

    public static volatile SingularAttribute<Fornecedor, Cidade> cidade;
    public static volatile SingularAttribute<Fornecedor, String> telefone;
    public static volatile SingularAttribute<Fornecedor, String> site;
    public static volatile SingularAttribute<Fornecedor, String> endereco;
    public static volatile SingularAttribute<Fornecedor, String> nomeContato;
    public static volatile SingularAttribute<Fornecedor, String> cnpj;
    public static volatile SingularAttribute<Fornecedor, String> email;

}