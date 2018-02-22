package domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person {
	private long idPerson;
	private String name;
	private String firstName;
	private String mail;
	private Collection<Home> home;
	private Collection<ElectronicDevice> electronicDevices;
	private Collection<Person> friends;

	public Person() {
	}

	public Person(String name, String firstName, String mail) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.mail = mail;
		this.home = new ArrayList<Home>();
		this.electronicDevices = new ArrayList<ElectronicDevice>();
		this.friends = new ArrayList<Person>();
	}

	@Id
	@GeneratedValue
	public long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(long idPerson) {
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

	@OneToMany
	@JoinColumn(name = "idPerson")
	public Collection<Home> getHome() {
		return home;
	}

	public void setHome(Collection<Home> home) {
		this.home = home;
	}

	@OneToMany
	@JoinColumn(name = "idPerson")
	public Collection<ElectronicDevice> getElectronicDevices() {
		return electronicDevices;
	}

	public void setElectronicDevices(Collection<ElectronicDevice> electronicDevices) {
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
