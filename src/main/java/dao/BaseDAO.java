package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

public class BaseDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    private static EntityManager MANAGER = factory.createEntityManager();

    public static EntityManager getManagerInstance() {
        return MANAGER;
    }

}


