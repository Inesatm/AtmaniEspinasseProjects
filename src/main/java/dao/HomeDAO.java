package dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import domain.Home;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 
public class HomeDAO {
	
    public static Boolean createHome(Home home) {
        EntityTransaction tx = BaseDAO.getEntityManager().getTransaction();
        tx.begin();
        try {
        	BaseDAO.getEntityManager().persist(home);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
    
    public static List<Home> getHomes() {
        return BaseDAO.getEntityManager().createQuery("Select h From Home h", Home.class).getResultList();
    }

    public static Home getHomeById(int id) {
        return BaseDAO.getEntityManager().createQuery("Select h From Home h where h.id=:id", Home.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
