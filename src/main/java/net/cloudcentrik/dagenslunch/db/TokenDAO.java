package net.cloudcentrik.dagenslunch.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import io.dropwizard.hibernate.AbstractDAO;
import net.cloudcentrik.dagenslunch.core.Token;

public class TokenDAO extends AbstractDAO<Token>{
	
	public TokenDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Token> findById(Long id) {
        return Optional.ofNullable(get(id));
    }
    
    public Token findByLongId(Long id) {
        return (Token) currentSession().get(Token.class, id);
    }

    public Token create(Token token) {
        
    	System.out.println("------------------------>>>>>>>>>>>>>>>>>>> "+token.getId());
    	return persist(token);
    }

    public List<Token> findAll() {
        return list(namedQuery("net.cloudcentrik.dagenslunch.core.Token.findAll"));
    }
    
    public void delete(Token token) {
        currentSession().delete(token);
    }
    
    public void update(Token token) {
        currentSession().saveOrUpdate(token);
    }

}
