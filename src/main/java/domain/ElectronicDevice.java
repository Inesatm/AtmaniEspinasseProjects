package domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice extends SmartDevices {

	private Person person;
	private int consumption;

	public ElectronicDevice() {
	}

	public ElectronicDevice(Person person, int consumption) {
		this.person = person;
		this.consumption = consumption;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getConsumption() {
		return consumption;
	}

	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}

}
