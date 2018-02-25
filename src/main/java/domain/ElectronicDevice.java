package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice {

	private String name;
	private int idED;
	private int consumption;
	private Person person;


	public ElectronicDevice() {
	}

	public ElectronicDevice(String name, int consumption, Person person) {
		this.name = name;
		this.idED = idED;
		this.consumption = consumption;
		this.person = person;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNom(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public int getIdED() {
		return idED;
	}
	
	public void setId(int idED) {
		this.idED = idED;
	}


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
	

}
