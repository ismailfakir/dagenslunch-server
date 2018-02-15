package net.cloudcentrik.dagenslunch.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import io.dropwizard.hibernate.AbstractDAO;
import net.cloudcentrik.dagenslunch.core.Restaurant;
import net.cloudcentrik.dagenslunch.core.RetaurantBasicResult;

public class RestaurantDAO extends AbstractDAO<Restaurant>{
	
	public RestaurantDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Restaurant> findById(int id) {
        return Optional.ofNullable(get(id));
    }
    
    public Restaurant findByIntId(int id) {
        return currentSession().get(Restaurant.class, id);
    }

    public Restaurant create(Restaurant restaurant) {
        return persist(restaurant);
    }

    public List<Restaurant> findAll() {
        return list(namedQuery("net.cloudcentrik.dagenslunch.core.Restaurant.findAll"));
        
    }
    
    public List<RetaurantBasicResult> findAllBasic(){
    	
    	String sqlQuery = "SELECT id AS id," +
    	        "name AS name,"+
    	        "category AS category,"+
    	        "latitude AS latitude,"+
    	        "longitude AS longitude"+
    			" from restaurant";

    	@SuppressWarnings("unchecked")
		List<RetaurantBasicResult> basicRestaurantList = currentSession()
    	        .createSQLQuery(sqlQuery)
    	        .setResultTransformer(Transformers.aliasToBean(RetaurantBasicResult.class))
    	        .list();
    	return basicRestaurantList;
    }
    
    public void delete(Restaurant restaurant) {
        currentSession().delete(restaurant);
    }
    
    public void update(Restaurant restaurant) {
        currentSession().saveOrUpdate(restaurant);
    }

}
