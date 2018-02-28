package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

public class BaseDAO {
	//private static final String PERSISTENCE_UNIT_NAME = "Test";
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");

	public static EntityManager getEntityManager() {
	      return factory.createEntityManager();
	} 

}


