package jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 
public class JpaTest {
	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.createScene();

		manager.close();
		System.out.println(".. done");
	}
	
	private void createScene() {
		
		/* --------- Collections ---------*/
		
		// Electronic Devices
		Collection<ElectronicDevice> elecD1 = new ArrayList<ElectronicDevice>();
		Collection<ElectronicDevice> elecD2 = new ArrayList<ElectronicDevice>();
		Collection<ElectronicDevice> elecD3 = new ArrayList<ElectronicDevice>();
		
		// Homes
		Collection<Home> homes1 = new ArrayList<Home>();
		Collection<Home> homes2 = new ArrayList<Home>();
		
		// Persons
		Collection<Person> consumers1 = new ArrayList<Person>();
		Collection<Person> consumers2 = new ArrayList<Person>();
		
		// Heaters
		Collection<Heater> heaters1 = new ArrayList<Heater>();
		Collection<Heater> heaters2 = new ArrayList<Heater>();
		
		// F.R.I.E.N.D.S
		Collection<Person> friends1 = new ArrayList<Person>();
		Collection<Person> friends2 = new ArrayList<Person>();
		Collection<Person> friends3 = new ArrayList<Person>();	
			

		/* --------- Creation ---------*/
	
		// Persons
		Person p1 = new Person("Ines", "Atm", "ineskatm@gmail.com");
		Person p2 = new Person("Dimas", "Do", "dimas35000@gmail.com ");
		Person p3 = new Person("Jane", "Doe", "janedoe@gmail.com");
		Person p4 = new Person("Jack", "Doe", "jackdoe@gmail.com");
		
		// Electronic Devices
		ElectronicDevice ed1 = new ElectronicDevice(p1, "Enceintes", 300);
		ElectronicDevice ed2 = new ElectronicDevice(p2, "Ordi", 3000);
		ElectronicDevice ed3 = new ElectronicDevice(p3, "Four", 1000);
		ElectronicDevice ed4 = new ElectronicDevice(p4, "Frigo", 1000);
		ElectronicDevice ed5 = new ElectronicDevice(p1, "Télé", 5550);
		ElectronicDevice ed6 = new ElectronicDevice(p2, "Lave vaisselle", 1430);
		
		// Homes
		Home home1 = new Home((long) 125.00, 7, heaters1, consumers1);
		Home home2 = new Home((long) 55.75, 3, heaters2, consumers2);

		// Heaters
		Heater h1 = new Heater("Couloir", 100);
		Heater h2 = new Heater("Salle de bain", 200);
		Heater h3 = new Heater("Logia", 1000);
		Heater h4 = new Heater("Cuisine", 489);

		
		/* --------- Ajout dans la collection ---------*/
			
		// Electronic Devices 
		elecD1.add(ed1);
		elecD1.add(ed2);
		elecD1.add(ed3);
		elecD2.add(ed4);
		elecD3.add(ed5);
		elecD3.add(ed6);	

		p1.setDevices(elecD1);
		p2.setDevices(elecD2);
		p3.setDevices(elecD3);
		
		// Heaters
		heaters1.add(h1);
		heaters1.add(h2);
		heaters1.add(h3);
		heaters1.add(h4);
		heaters2.add(h1);
		heaters2.add(h2);

		
		// Consumers
		consumers1.add(p1);
		consumers1.add(p2);
		consumers2.add(p3);	
			
		// Homes
		homes1.add(home1);
		homes2.add(home2);

        h1.setHome(home1);
        h2.setHome(home1);
        h4.setHome(home1);
        h3.setHome(home2);

		
		// F.R.I.E.N.D.S
		friends1.add(p4);
		friends1.add(p3);
		friends2.add(p1);
		friends2.add(p3);
		friends3.add(p1);
		friends3.add(p2);
		
		// Persons 
		p1.setFriends(friends1);
		p2.setFriends(friends2);
		p3.setFriends(friends3);
		
		p1.setHomes(homes1);
		p2.setHomes(homes1);
		p3.setHomes(homes2);
		
		home1.setConsumers(consumers1);
		home2.setConsumers(consumers2);	

		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
	
	}
	
	private static void getAllPersons(EntityManager manager) {
	
		
		Collection<Person> persons = manager.createQuery( "SELECT p FROM Person p", Person.class).getResultList();
		
		System.out.println("Nombre de personnes : " + persons.size());
		
		for (Person p : persons) {
			System.out.println("Personne : " + persons.toString());
		}
	}
	
	public static void getPersonByName(EntityManager manager) {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
		Root<Person> from = query.from(Person.class);
		
		query.select(from.get("name"));
		
		System.out.println(manager.createQuery(query).getResultList());
	}
	
	public static void getPersonById(EntityManager manager) {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
		Root<Person> from = query.from(Person.class);
		
		query.select(from.get("id"));
		
		System.out.println(manager.createQuery(query).getResultList());
	}
}
