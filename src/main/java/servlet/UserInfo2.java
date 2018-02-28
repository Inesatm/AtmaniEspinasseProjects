package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.PersonDAO;
import domain.Person;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@WebServlet(name="person",urlPatterns={"/person"})
public class UserInfo2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printer = new PrintWriter(resp.getOutputStream());
        JSONArray jsonLstPersons = new JSONArray();

        for(Person p : PersonDAO.getPersons()){
            JSONObject jsonPerson = new JSONObject();
            jsonPerson.put("firstName",p.getFirstName());
            jsonPerson.put("lastName",p.getLastName());
            jsonPerson.put("mail",p.getMail());
            jsonLstPersons.put(jsonPerson);
        }
        printer.print(jsonLstPersons);
        printer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String mail = req.getParameter("mail");

        Person p = new Person();
        p.setMail(mail);
        p.setFirstName(firstName);
        p.setLastName(lastName);

        JSONObject jsonPerson = new JSONObject();

        if(PersonDAO.createPerson(p)){
            jsonPerson.put("firstName",firstName);
            jsonPerson.put("firstName",firstName);
            jsonPerson.put("mail",mail);
            jsonPerson.put("Message","Cette personne a bien été créée !");
        } else {
            jsonPerson.put("Message","Erreur lors de la création");
        }
        out.print(jsonPerson);
    }


}
