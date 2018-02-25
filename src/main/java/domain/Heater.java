package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater  {

	private Home home;
	private String room;
	private int idHeater;
	private int consumption;

	public Heater() {
	}

    public Heater(Home home, String room, int consumption) {
        this.home = home;    
        this.room = room;
        this.consumption = consumption;
    }

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	
	public String getRoom() {
		return room;
	}
	
	public void setNom(String room) {
		this.room = room;
	}
	
	@Id
	@GeneratedValue
	public int getIdHeater() {
		return idHeater;
	}

	public void setIdHeater(int idHeater) {
		this.idHeater = idHeater;
	}
	
	public int getConsumption() {
		return consumption;
	}

	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}

}
