package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Heater extends SmartDevices {
	
	private int idHeater;
	
	public Heater() {	}
	@Id
	@GeneratedValue
	public int getIdHeater() {
		return idHeater;
	}
	public void setIdHeater(int idHeater) {
		this.idHeater = idHeater;
	}

}
