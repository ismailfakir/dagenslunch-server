package net.cloudcentrik.dagenslunch.db;

import net.cloudcentrik.dagenslunch.core.People;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Optional;

public class PeopleDAO extends AbstractDAO<People> {
    public PeopleDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<People> findById(Long id) {
        return Optional.ofNullable(get(id));
    }
    
    public People findByLongId(Long id) {
        return (People) currentSession().get(People.class, id);
    }

    public People create(People person) {
    	
    	Logger logger = LoggerFactory.getLogger("Dagenslunch");
        logger.info("before creating a people in database");

    	
        return persist(person);
    }

    public List<People> findAll() {
        return list(namedQuery("net.cloudcentrik.dagenslunch.core.People.findAll"));
    }
    
    public void delete(People person) {
        currentSession().delete(person);
    }
    
    public void update(People person) {
        currentSession().saveOrUpdate(person);
    }
}
