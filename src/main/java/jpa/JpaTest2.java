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

public class JpaTest2 {
	private EntityManager manager;

	public JpaTest2(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest2 test = new JpaTest2(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.createPersons();

		manager.close();
		System.out.println(".. done");
	}

	private void createPersons() {

		Collection<Heater> heaters = new ArrayList();
		Collection<Heater> heaters1 = new ArrayList();
		Collection<Person> friends1 = new ArrayList();
		Collection<Person> friends2 = new ArrayList();
		Collection<Person> friends3 = new ArrayList();
		Collection<Person> friends4 = new ArrayList();
		Collection<Home> homes = new ArrayList();
		Collection<Home> homes1 = new ArrayList();
		Collection<ElectronicDevice> elecD = new ArrayList();
		Home home1 = new Home(20, 1, heaters);
		Home home2 = new Home(20, 1, heaters1);
		Heater h1 = new Heater();
		Heater h2 = new Heater();

		heaters.add(h1);
		heaters1.add(h2);
		ElectronicDevice elec = new ElectronicDevice();

		elecD.add(elec);
		homes.add(home1);
		homes1.add(home2);
		Person p1 = new Person("Ines", "Atm", "ineskatm@gmail.com", homes, elecD, friends1);
		Person p2 = new Person("Dimas", "Do", "dimas35000@gmail.com ", homes1, elecD, friends2);
		Person p3 = new Person("Jane", "Doe", "janedoe@gmail.com", homes, elecD, friends3);
		Person p4 = new Person("Jack", "Doe", "jackdoe@gmail.com", homes1, elecD, friends4);
		friends1.add(p2);
		friends2.add(p1);
		friends3.add(p1);
		friends3.addAll(friends1);
		friends4.addAll(friends3);

		manager.persist(home1);
		manager.persist(home2);
		manager.persist(elec);
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
		manager.persist(h1);
		manager.persist(h2);

	}

}
