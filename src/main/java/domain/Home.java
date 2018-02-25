package domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

import org.hibernate.loader.CollectionAliases;

@Entity
public class Home {

	private String name;
	private int idHome;
	private Person person;
	private int size;
	private int nbRooms;
	private Collection<Heater> heaters;
	private Collection<Person> persons;

	public Home() {

	}

	public Home(String name, int size, int nbRooms, Collection<Heater> heaters, Collection<Person> persons) {
		this.name = name;
		this.size = size;
		this.nbRooms = nbRooms;
		this.heaters = heaters;
		this.persons = persons;
	}

	@Id
	@GeneratedValue
	public int getIdHome() {
		return idHome;
	}

	public void setIdHome(int idHome) {
		this.idHome = idHome;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getNbRooms() {
		return nbRooms;
	}

	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}

	@OneToMany(mappedBy = "home")
	public Collection<Heater> getHeaters() {
		return heaters;
	}

	public void setHeaters(Collection<Heater> heaters) {
		this.heaters = heaters;
	}
	

	
	@ManyToMany
	public Collection<Person> getPersons() {
		return persons;
	}
	
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
	

}
