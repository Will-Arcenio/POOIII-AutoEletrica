
package Dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class Banco {
    private static EntityManager entity = null;
    
    public static EntityManager getEntity() {
        if (entity == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectEletricaPU");
            entity = factory.createEntityManager();
        }
        
        return entity;
    }
}
