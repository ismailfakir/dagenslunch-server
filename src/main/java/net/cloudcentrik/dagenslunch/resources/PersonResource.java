package net.cloudcentrik.dagenslunch.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.cloudcentrik.dagenslunch.core.People;
import net.cloudcentrik.dagenslunch.db.PeopleDAO;
import net.cloudcentrik.dagenslunch.views.PersonView;

@Path("/people/{id}")
@Produces(MediaType.TEXT_HTML)
public class PersonResource {
    private final PeopleDAO dao;

    public PersonResource(PeopleDAO dao) {
        this.dao = dao;
    }

    @GET
    public PersonView getPerson(@PathParam("id") String id) {
        return new PersonView(new People("ismail","test"));
    }
}