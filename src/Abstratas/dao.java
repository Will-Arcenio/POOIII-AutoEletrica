
package Abstratas;

import Dados.Banco;
import java.util.List;
import javax.persistence.Query;

abstract public class dao<T> {
    
    public void create(T objeto) {
        Banco.getEntity().getTransaction().begin();
        Banco.getEntity().persist(objeto);
        Banco.getEntity().getTransaction().commit();
    }
    
    public void update(T objeto) {
        Banco.getEntity().getTransaction().begin();
        Banco.getEntity().merge(objeto);
        Banco.getEntity().getTransaction().commit();
    }
    
    public void delete(T objeto) {
        Banco.getEntity().getTransaction().begin();
        Banco.getEntity().remove(objeto);
        Banco.getEntity().getTransaction().commit();
    }
    
    public T read(Class<T> classToCast, int id) {
        return Banco.getEntity().find(classToCast, id);
    }
    
    //
    protected List<T> read(String JPQL) {
        Query query = Banco.getEntity().createQuery(JPQL);
        return query.getResultList();
    }
    
    protected List<T> read(String JPQL, Object... args) {
        Query query = Banco.getEntity().createQuery(JPQL);
        for (int i = 0; i < args.length; i++) {
            query.setParameter((i+1), args[i]);
        }
        return query.getResultList();
    }
    
}
