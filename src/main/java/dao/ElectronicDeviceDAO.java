package dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import domain.ElectronicDevice;

/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 
public class ElectronicDeviceDAO {
	
    public static Boolean createElectronicDevice(ElectronicDevice ed) {
        EntityTransaction tx = BaseDAO.getManagerInstance().getTransaction();
        tx.begin();
        try {
        	BaseDAO.getManagerInstance().persist(ed);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
    
    public static List<ElectronicDevice> getHeaters() {
        return BaseDAO.getManagerInstance().createQuery("Select e From ElectronicDevice e", ElectronicDevice.class).getResultList();
    }

    public static ElectronicDevice getHeaterById(int id) {
        return BaseDAO.getManagerInstance().createQuery("Select e From ElectronicDevice e where e.id=:id", ElectronicDevice.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
