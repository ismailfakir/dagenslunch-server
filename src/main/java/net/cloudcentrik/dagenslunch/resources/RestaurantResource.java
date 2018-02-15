package net.cloudcentrik.dagenslunch.resources;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.cloudcentrik.dagenslunch.auth.DagenslunchCredential;

import net.cloudcentrik.dagenslunch.core.Restaurant;
import net.cloudcentrik.dagenslunch.core.RetaurantBasicResult;
import net.cloudcentrik.dagenslunch.db.RestaurantDAO;


@Path("/restaurant")
@Api(value = "/restaurant")
@Produces(MediaType.APPLICATION_JSON)
public class RestaurantResource {
	
	private final RestaurantDAO restaurantDAO;

    public RestaurantResource(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "Add a new Restaurant")
    @ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input") })
    public Restaurant createPerson(
    		@ApiParam(value = "Restaurant object that needs to be added to database", required = true)Restaurant restaurant) {
        return restaurantDAO.create(restaurant);
    }

    @GET
    @UnitOfWork
    @ApiOperation(
            value = "Find all restaurant",
            notes = "Returns list of Restaurant",
            response = Restaurant.class,
            responseContainer = "List")
    public List<Restaurant> listRestaurant() {
        return restaurantDAO.findAll();
    }
    
    @RolesAllowed({ DagenslunchCredential.USER_ROLE })
    @GET
    @Path("/basic")
    @UnitOfWork
    public List<RetaurantBasicResult> listBasicRestaurant(){
        return restaurantDAO.findAllBasic();
    }
    
    @GET
    @Path("/{id}")
    @UnitOfWork
    /*swagger annotation start*/
    @ApiOperation(value = "Get a Restaurant by id")
    @ApiResponses(value = { 
    		@ApiResponse(code = 400, message = "Error Occurred while getting data"),
    		@ApiResponse(code = 404, message = "Restaurant not found"),
    		@ApiResponse(code = 405, message = "Validation exception") 
    })
    /*swagger annotation end*/
    public Optional<Restaurant> get(
    		@ApiParam(value = "Restaurant id", required = true)//swagger annotation
    		@PathParam("id") int id){
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


     


