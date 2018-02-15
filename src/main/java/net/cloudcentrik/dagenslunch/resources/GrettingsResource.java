package net.cloudcentrik.dagenslunch.resources;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import net.cloudcentrik.dagenslunch.api.Grettings;
import io.swagger.annotations.ApiResponse;

@Path("/info")
@Produces(MediaType.APPLICATION_JSON)
public class GrettingsResource {

	public GrettingsResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
    @Timed
    
	public Grettings sendGrettings(@Context HttpServletRequest req) {
		final HashMap<String,String> serverInfo=new HashMap<String,String>();
		serverInfo.put("SERVER","dagenslunch");
		serverInfo.put("VERSION","1.0");
		serverInfo.put("FORMAT","JSON");
		serverInfo.put("BASE URL","https://dagens-lunch-v1.herokuapp.com/");
		serverInfo.put("GET RESTAURANT","BASE_URL/restaurant");
		serverInfo.put("GET RESTAURANT","BASE_URL/restaurant/basic");
        return new Grettings(serverInfo);
    }

}
