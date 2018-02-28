package dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import domain.Heater;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 
public class HeaterDAO {
	
    public static Boolean createHeater(Heater heater) {
        EntityTransaction tx = BaseDAO.getEntityManager().getTransaction();
        tx.begin();
        try {
            BaseDAO.getEntityManager().persist(heater);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
    
    public static List<Heater> getHeaters() {
        return BaseDAO.getEntityManager().createQuery("Select h From Heater h", Heater.class).getResultList();
    }

    public static Heater getHeaterById(int id){
        return BaseDAO.getEntityManager().createQuery("Select h From Heater h where h.id=:id", Heater.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    
/*	public Heater createHeater(String name, int conso) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();		
		
		EntityTransaction tx = null;
		Heater heater = null;
		try{
			tx = manager.getTransaction();
			tx.begin();
			heater = new Heater(name,conso);
			manager.persist(heater);
			tx.commit();
		}catch(Exception re)
		{
			if(tx!=null){
				System.out.println("Oops, something went wrong");
				tx.rollback();
			}
		}finally{
			manager.close();
			factory.close();
		}
		return heater;
	}*/

}


