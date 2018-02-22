package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ElectronicDevice extends SmartDevices{

	private int idElectronicDevice;
	
	public ElectronicDevice() {
	}
	@Id
	@GeneratedValue
	public int getIdElectronicDevice() {
		return idElectronicDevice;
	}
	public void setIdElectronicDevice(int idElectronicDevice) {
		this.idElectronicDevice = idElectronicDevice;
	}

}
