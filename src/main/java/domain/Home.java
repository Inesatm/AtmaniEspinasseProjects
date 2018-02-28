package domain;


import java.security.acl.Owner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Entity
@Table(name = "Home")
public class Home {
	
	private long id;
	private long size;
	private int nbRooms;
	private Collection<Heater> heaters;
	private Collection<Person> consumers;

	public Home() {

	}
	
	public Home(long size, int nbRooms, Collection<Heater> heaters, Collection<Person> consumers) {
		this.size = size;
		this.nbRooms = nbRooms;
		this.heaters = heaters;
		this.consumers = consumers;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "Size")
	public long getSize() {
		return size;
	}
	
	public void setSize(long size) {
		this.size = size;
	}
	
	@Basic
	@Column(name = "NbRooms")
	public int getNbRooms() {
		return nbRooms;
	}

	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}

	@OneToMany(mappedBy="home", cascade = CascadeType.PERSIST)
	public Collection<Heater> getHeaters() {
		return heaters;
	}
	
	public void setHeaters(Collection<Heater> heaters) {
		this.heaters = heaters;
	}

	@ManyToMany
	public Collection<Person> getConsumers() {
		return consumers;
	}

	public void setConsumers(Collection<Person> consumers) {
		this.consumers = consumers;
	}

    @Override
	public String toString() {
		String result = "Home [size=" + size + ", nbRooms=" + nbRooms + "]";
		
		for(Heater heater : this.heaters) {
			result += heater.toString();
		}
		
		return result;
	}
}
