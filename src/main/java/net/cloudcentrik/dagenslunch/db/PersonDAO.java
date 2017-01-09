package net.cloudcentrik.dagenslunch.db;

import net.cloudcentrik.dagenslunch.core.Person;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PersonDAO extends AbstractDAO<Person> {
    public PersonDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Person create(Person person) {
        return persist(person);
    }

    public List<Person> findAll() {
        return list(namedQuery("net.cloudcentrik.dagenslunch.core.Person.findAll"));
    }
    
    public void delete(Optional<Person> person) {
        currentSession().delete(person);
    }
    
    public void update(Person person) {
        currentSession().saveOrUpdate(person);
    }
}
