package net.cloudcentrik.dagenslunch.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import io.dropwizard.hibernate.UnitOfWork;
import net.cloudcentrik.dagenslunch.db.RestaurantDAO;
import net.cloudcentrik.dagenslunch.views.IndexView;
import net.cloudcentrik.dagenslunch.views.LoginView;
import net.cloudcentrik.dagenslunch.views.RestaurantsView;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class IndexResource {
	private final RestaurantDAO restaurantDAO;
	public IndexResource(RestaurantDAO restaurantDAO) {
		this.restaurantDAO=restaurantDAO;
	}
	
	@GET
	@UnitOfWork
	@Path("/restaurants")
    public RestaurantsView getAllRestaurent() {
        return new RestaurantsView(restaurantDAO.findAll());
    }

	@GET
	@UnitOfWork
	@Path("/login")
    public LoginView getLogin() {
        return new  LoginView();
    }
	
	@POST
	@UnitOfWork
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public IndexView getIndex(@FormParam("userName") String userName,@FormParam("password") String password) {
        
		if(userName.equals("admin")&&password.equals("open123")) {
			return new  IndexView(userName);
        }else {
        	
            return new  IndexView("");
        }
		
    }
	
}
