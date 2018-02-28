package servlet;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;


/**
 * @author Dimas  Espinasse - Ines Atmani
 */ 

@WebServlet(name="allinfo", urlPatterns={"/AllInfo"})
public class UserInfo1  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();

        Collection<Person> resultList = manager.createQuery("Select p from Person p", Person.class).getResultList();

        out.println( "<html>\n<body>\n" +
                "<h1>Recapitulatif des informations</h1>\n");

        for(Person p : resultList) {
            out.println("<ul></li><li>Prenom: "
                    + p.getFirstName() + "\n" +
                    " <li>Nom: "
                    + p.getLastName() + "\n" +
                    " </li><li>Mail: "
                    + p.getMail() + "\n" +
                    "</li><li>" + "\n");
        }

        out.println( "</body></html>" );
    }
}