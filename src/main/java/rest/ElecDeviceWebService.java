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

import dao.ElectronicDeviceDAO;
import dao.HomeDAO;
import domain.ElectronicDevice;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@Path("/electronicdevice")
public class ElecDeviceWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ElectronicDevice> getAllEd() {
        return ElectronicDeviceDAO.getHeaters();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public ElectronicDevice findById(@PathParam("id") int id) {
        return ElectronicDeviceDAO.getHeaterById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createEd(String jsonStringEd) {
        JSONObject jsonEd = new JSONObject(jsonStringEd);
        ElectronicDevice ed = new ElectronicDevice();
        ed.setConsumption(jsonEd.getInt("consumption"));
        //ed.setHome(HomeDAO.getHomeById(jsonEd.getInt("id")));
        return ElectronicDeviceDAO.createElectronicDevice(ed);
    }
}
