package model;

import Abstratas.Base_;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cidade;
import model.Funcao;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-06-20T18:00:23", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ extends Base_ {

    public static volatile SingularAttribute<Funcionario, Funcao> funcao;
    public static volatile SingularAttribute<Funcionario, LocalDate> dataDemissao;
    public static volatile SingularAttribute<Funcionario, Cidade> cidade;
    public static volatile SingularAttribute<Funcionario, String> telefone;
    public static volatile SingularAttribute<Funcionario, String> endereco;
    public static volatile SingularAttribute<Funcionario, String> cpf;
    public static volatile SingularAttribute<Funcionario, LocalDate> dataAdmissao;

}