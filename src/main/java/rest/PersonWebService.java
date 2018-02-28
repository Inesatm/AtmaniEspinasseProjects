package rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.HomeDAO;
import dao.PersonDAO;
import domain.Home;
import domain.Person;

/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Path("/person")
public class PersonWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return PersonDAO.getPersons();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person findById(@PathParam("id") int id) {
        return PersonDAO.getPersonById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createPerson(String jsonStringPerson)  {
        List<Home> homes = new ArrayList<Home>();

        JSONObject jsonPerson = new JSONObject(jsonStringPerson);
        JSONArray jsonHomes = jsonPerson.getJSONArray("homesChecked");
        for(int i = 0; i < jsonHomes.length(); i++){
            Home h = HomeDAO.getHomeById(jsonHomes.getJSONObject(i).getInt("idHome"));
            homes.add(h);
        }
        Person person = new Person();
        person.setFirstName(jsonPerson.getString("firstName"));
        person.setLastName(jsonPerson.getString("lastName"));
        person.setMail(jsonPerson.getString("mail"));
        person.setHomes(homes);
        return PersonDAO.createPerson(person);
    }
}