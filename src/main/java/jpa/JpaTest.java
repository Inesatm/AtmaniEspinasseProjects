package jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

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
		
		Collection<Heater> heaters = new ArrayList<Heater>();
		Collection<Heater> heaters1 = new ArrayList<Heater>();
		Collection<Person> persons = new ArrayList<Person>();
		Collection<Person> friends1 = new ArrayList<Person>();
		Collection<Person> friends2 = new ArrayList<Person>();
		Collection<Person> friends3 = new ArrayList<Person>();
		Collection<Person> friends4 = new ArrayList<Person>();
		Collection<Home> homes = new ArrayList<Home>();
		Collection<Home> homes1 = new ArrayList<Home>();
		Collection<ElectronicDevice> elecD = new ArrayList<ElectronicDevice>();
		
		Heater h1 = new Heater();
		Heater h2 = new Heater();

		heaters.add(h1);
		heaters1.add(h2);
		ElectronicDevice elec = new ElectronicDevice();
		


		// Persons
		Person p1 = new Person("Ines", "Atm", "ineskatm@gmail.com", homes, elecD, friends1);
		Person p2 = new Person("Dimas", "Do", "dimas35000@gmail.com ", homes1, elecD, friends2);
		Person p3 = new Person("Jane", "Doe", "janedoe@gmail.com", homes1, elecD, friends3);
		Person p4 = new Person("Jack", "Doe", "jackdoe@gmail.com", homes, elecD, friends4);
		// Friends
		friends1.add(p2);
		friends2.add(p1);
		friends3.add(p1);
		friends3.addAll(friends1);
		friends4.addAll(friends3);
		
		// Homes
		Home home1 = new Home("Mirabeau", 555, 4, heaters, friends4);
		Home home2 = new Home("Villejean", 1588, 1, heaters1, friends2);
		
		// Electronic Devices
		ElectronicDevice ed1 = new ElectronicDevice("Enceintes", 300, p1);
		ElectronicDevice ed2 = new ElectronicDevice("Ordi",3000, p2);
		ElectronicDevice ed3 = new ElectronicDevice("Four",1000, p3);
		ElectronicDevice ed4 = new ElectronicDevice("Frigo",1000, p4);
		ElectronicDevice ed5 = new ElectronicDevice("Télé",5550, p2);
		ElectronicDevice ed6 = new ElectronicDevice("Lave vaisselle",1430, p1);

		// Heaters
		Heater heater1 = new Heater(home1, "Couloir", 100);
		Heater heater2 = new Heater(home1, "Salle de bain", 200);
		Heater heater3 = new Heater(home2, "Logia", 1000);
		Heater heater4 = new Heater(home2, "Cuisine", 489);
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);

		home1.addHeater(heater1);
		home2.addHeater(heater2);
		
		
		
		elecD.add(elec);
		homes.add(home1);
		homes1.add(home2);
		
		heaters.add(heater1);
		heaters.add(heater2);
		heaters1.add(heater3);
		heaters1.add(heater4);



		
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
 



/*		Collection<Heater> heaters = new ArrayList();
		Collection<Heater> heaters1 = new ArrayList();
		Collection<Person> friends1 = new ArrayList();
		Collection<Person> friends2 = new ArrayList();
		Collection<Person> friends3 = new ArrayList();
		Collection<Person> friends4 = new ArrayList();
		Collection<Home> homes = new ArrayList();
		Collection<Home> homes1 = new ArrayList();
		Collection<ElectronicDevice> elecD = new ArrayList();
		
		Heater h1 = new Heater();
		Heater h2 = new Heater();
		
		heaters.add(h1);
		heaters1.add(h2);
		ElectronicDevice elec = new ElectronicDevice();

		elecD.add(elec);
		homes.add(home1);
		homes1.add(home2);

		friends1.add(p2);
		friends2.add(p1);
		friends3.add(p1);
		friends3.addAll(friends1);
		friends4.addAll(friends3);
		
		*/

	}

}
