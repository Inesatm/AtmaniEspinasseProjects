package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 


public abstract class SmartDevices {
	
	private long id;
	private int consumption;
	
	public SmartDevices(){
		
	}
	
	public SmartDevices(int consumption) {
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
	public int getConsumption() {
		return consumption;
	}
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}
	
}

