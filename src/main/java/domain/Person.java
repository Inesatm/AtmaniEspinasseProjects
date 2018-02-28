package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Collection;

import javax.persistence.*;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Entity
@Table(name = "Person")
public class Person {
	
	private long id;
	private String firstName;
	private String lastName;
	private String mail;
	private Collection<Home> homes;
	private Collection<Person> friends;
	private Collection<ElectronicDevice> devices;

	public Person() {

	}
	
	public Person(String firstName, String lastName, String mail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
	}
	
	public Person(String firstName, String lastName, String mail, Collection<ElectronicDevice> devices) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.devices = devices;
	}
	
	public Person(String firstName, String lastName, String mail, Collection<Home> homes, Collection<Person> friends, Collection<ElectronicDevice> devices) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.homes = homes;
		this.friends = friends;
		this.devices = devices;
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
	@Column(name = "FirstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "Mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@ManyToMany(mappedBy="consumers", cascade = CascadeType.PERSIST)
	public Collection<Home> getHomes() {
		return homes;
	}

	public void setHomes(Collection<Home> homes) {
		this.homes = homes;
	}

	@ManyToMany
	public Collection<Person> getFriends() {
		return friends;
	}

	public void setFriends(Collection<Person> friends) {
		this.friends = friends;
	}

	@OneToMany(mappedBy="person", cascade = CascadeType.PERSIST)
	public Collection<ElectronicDevice> getDevices() {
		return devices;
	}

	public void setDevices(Collection<ElectronicDevice> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		String result = "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + "]";
		
		return result;
	}
}