package net.cloudcentrik.dagenslunch.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import net.cloudcentrik.dagenslunch.core.Restaurant;
import net.cloudcentrik.dagenslunch.db.RestaurantDAO;

@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
public class RestaurantResource {
	
	private final RestaurantDAO restaurantDAO;

    public RestaurantResource(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    @POST
    @UnitOfWork
    public Restaurant createPerson(Restaurant restaurant) {
        return restaurantDAO.create(restaurant);
    }

    @GET
    @UnitOfWork
    public List<Restaurant> listRestaurant() {
        return restaurantDAO.findAll();
    }
    
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<Restaurant> get(@PathParam("id") int id){
        return restaurantDAO.findById(id);
    }
    
    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Restaurant update(@PathParam("id") int id, @Valid Restaurant restaurant) {
    	restaurant = restaurant.setId(id);
    	restaurantDAO.update(restaurant);

        return restaurant;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") int id) {
    	restaurantDAO.delete(restaurantDAO.findByIntId(id));
    }

}
