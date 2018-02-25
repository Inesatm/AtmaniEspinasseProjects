package domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person {
	private int idPerson;
	private String name;
	private String firstName;
	private String mail;
	private Collection<Home> homes;
	private Collection<ElectronicDevice> electronicDevices;
	private Collection<Person> friends;


	public Person() {
	}

	public Person(String name, String firstName, String mail, Collection<Home> homes, Collection<ElectronicDevice> electronicDevices, Collection<Person> friends) {
		this.name = name;
		this.firstName = firstName;
		this.mail = mail;
		this.electronicDevices =electronicDevices;
		this.friends = friends;
	}

	@Id
	@GeneratedValue
	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(mappedBy = "persons")
	public Collection<Home> getHomes() {
		return homes;
	}

	public void sethomes(Collection<Home> home) {
		this.homes = home;
	}


	@OneToMany(mappedBy="person")
	public Collection<ElectronicDevice> getDevices() {
		return electronicDevices;
	}

	public void setDevices(Collection<ElectronicDevice> electronicDevices) {
		this.electronicDevices = electronicDevices;
	}
	
	@ManyToMany
	public Collection<Person> getFriends() {
		return friends;
	}

	public void setFriends(Collection<Person> friends) {
		this.friends = friends;
	}
	


}
