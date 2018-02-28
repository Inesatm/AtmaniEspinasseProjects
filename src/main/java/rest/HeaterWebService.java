package rest;

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

import dao.HeaterDAO;
import dao.HomeDAO;
import domain.Heater;
import domain.Home;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Path("/heater")
public class HeaterWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Heater> getAllHeaters() {
        return HeaterDAO.getHeaters();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Heater findById(@PathParam("id") int id) {
        return HeaterDAO.getHeaterById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createHeater(String jsonStringHeater) {
        JSONObject jsonHeater = new JSONObject(jsonStringHeater);
        Heater heater = new Heater();
        heater.setConsumption(jsonHeater.getInt("consumption"));
        heater.setHome(HomeDAO.getHomeById(jsonHeater.getInt("idHome")));
        return HeaterDAO.createHeater(heater);
    }
}
