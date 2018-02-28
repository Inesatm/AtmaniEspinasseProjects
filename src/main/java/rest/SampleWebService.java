package rest;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Path("/API")
public class SampleWebService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Serveur de données OPower";
	}

}