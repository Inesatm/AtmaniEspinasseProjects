package domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Home {

	private int idHome;
	private int length;
	private int nbRoom;
	private Collection<Heater> heaters;;

	public Home(int length, int nbRoom) {

		this.length = length;
		this.nbRoom = nbRoom;
		this.heaters = new ArrayList<Heater>();;
	}

	@Id
	@GeneratedValue
	public int getIdHome() {
		return idHome;
	}

	public void setIdHome(int idHome) {
		this.idHome = idHome;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getNbRoom() {
		return nbRoom;
	}

	public void setNbRoom(int nbRoom) {
		this.nbRoom = nbRoom;
	}

	@OneToMany
	@JoinColumn(name = "idHome")
	public Collection<Heater> getHeaters() {
		return heaters;
	}

	public void setHeaters(Collection<Heater> heaters) {
		this.heaters = heaters;
	}

}
