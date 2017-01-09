package net.cloudcentrik.dagenslunch.resources;

import net.cloudcentrik.dagenslunch.core.Person;
import net.cloudcentrik.dagenslunch.db.PersonDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {

    private final PersonDAO peopleDAO;

    public PeopleResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @POST
    @UnitOfWork
    public Person createPerson(Person person) {
        return peopleDAO.create(person);
    }

    @GET
    @UnitOfWork
    public List<Person> listPeople() {
        return peopleDAO.findAll();
    }
    
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<Person> get(@PathParam("id") Long id){
        return peopleDAO.findById(id);
    }
    
    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Person update(@PathParam("id") Long id, @Valid Person person) {
        person = person.setId(id);
        peopleDAO.update(person);

        return person;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") Long id) {
    	peopleDAO.delete(peopleDAO.findByLongId(id));
    }

}
