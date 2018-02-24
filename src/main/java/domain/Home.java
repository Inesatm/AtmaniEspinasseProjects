package domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Home {

	private int idHome;
	private Person person;
	private int size;
	private int nbRooms;
	private Collection<Heater> heaters;

	public Home() {

	}

	public Home(int size, int nbRooms, Collection<Heater> heaters) {
		this.size = size;
		this.nbRooms = nbRooms;
		this.heaters = heaters;
	}

	@Id
	@GeneratedValue
	public int getIdHome() {
		return idHome;
	}

	public void setIdHome(int idHome) {
		this.idHome = idHome;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person landlord) {
		this.person = landlord;
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

	@OneToMany
	@JoinColumn(name = "idHome")
	public Collection<Heater> getHeaters() {
		return heaters;
	}

	public void setHeaters(Collection<Heater> heaters) {
		this.heaters = heaters;
	}

}
