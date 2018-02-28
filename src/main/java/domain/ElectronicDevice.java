package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Entity
@Table(name = "ElectronicDevice")
public class ElectronicDevice  {
	
	private Person person;
	private long id;
	private String name;
	private int consumption;
	
	public ElectronicDevice() {
	}
	
	public ElectronicDevice(Person person, String name, int consumption) {
		this.person = person;
		this.name = name;
		this.consumption = consumption;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "Consumption")
	public int getConsumption() {
		return consumption;
	}
	
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "ElectronicDevice [id=" + id + ", name=" + name + ", consumption=" + consumption + ", person=" + person + "]";
	}
}