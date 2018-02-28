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
@Table(name = "Heater")
public class Heater {
	
	private long id;
	private String name;
	private int consumption;
	private Home home;
	
	public Heater() {
		
	}

    public Heater(String name, int consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    public Heater(String name, int consumption, Home home) {
        this.name = name;
        this.consumption = consumption;
        this.home = home;
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
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "Heater [name=" + name + ", consumption=" + consumption + "]";
	}
}