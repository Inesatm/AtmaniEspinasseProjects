package domain;

import javax.persistence.*;

@Entity
public class SmartDevices {

	private int id;
	private String name;

	public SmartDevices() {
	}

	public SmartDevices(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
