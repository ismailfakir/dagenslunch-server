package net.cloudcentrik.dagenslunch.resources;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import net.cloudcentrik.dagenslunch.api.Grettings;

import com.codahale.metrics.annotation.Timed;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class GrettingsResource {

	public GrettingsResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
    @Timed
    public Grettings sendGrettings(@Context HttpServletRequest req) {
		final HashMap<String,String> serverInfo=new HashMap<String,String>();
		serverInfo.put("name","dagenslunch");
		serverInfo.put("version","1.0");
		serverInfo.put("your ip",req.getRemoteAddr());
		
        return new Grettings(serverInfo);
    }

}
