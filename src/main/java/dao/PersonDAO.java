package dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import domain.Person;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 
public class PersonDAO {
	
    public static Boolean createPerson(Person person){
        EntityTransaction tx = BaseDAO.getManagerInstance().getTransaction();
        tx.begin();
        try {
        	BaseDAO.getManagerInstance().persist(person);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
    
    
    public static List<Person> getPersons(){
        return BaseDAO.getManagerInstance().createQuery("Select p From Person p", Person.class).getResultList();
    }

    public static Person getPersonById(int id){
        return BaseDAO.getManagerInstance().createQuery("Select p From Person p where p.id=:id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
