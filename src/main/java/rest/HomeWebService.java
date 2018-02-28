package rest;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.HomeDAO;
import domain.Home;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Path("/home")
public class HomeWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Home> getAllHomes() {
        return HomeDAO.getHomes();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Home findById(@PathParam("id") int id) {
        return HomeDAO.getHomeById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createHome(String jsonStringHome) {
        JSONObject jsonHome = new JSONObject(jsonStringHome);
        Home home = new Home();
        home.setSize(jsonHome.getInt("size"));
        home.setNbRooms(jsonHome.getInt("nbRooms"));
        return HomeDAO.createHome(home);
    }
}
    
