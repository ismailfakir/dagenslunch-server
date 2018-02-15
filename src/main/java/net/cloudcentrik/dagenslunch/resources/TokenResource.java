package net.cloudcentrik.dagenslunch.resources;

import java.sql.Timestamp;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import net.cloudcentrik.dagenslunch.auth.DagenslunchAuthenticator;
import net.cloudcentrik.dagenslunch.core.Token;
import net.cloudcentrik.dagenslunch.db.TokenDAO;
import net.cloudcentrik.dagenslunch.utils.AuthenticationUtils;

@Path("/token")
@Api(value = "/token")
@Produces(MediaType.APPLICATION_JSON)
public class TokenResource {
	
	private final TokenDAO tokenDAO;

    public TokenResource(TokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
  
    }
    
    /*
     * user give crediantial in request header name: dagenslunch-crediential
     * crediantial format: MD5(dagens_lunch:cloudcentrik_2015)
     */
    
    @GET
    @UnitOfWork
    public Token get(@HeaderParam("dagenslunch-crediential") String crediantial){
        
    	if(AuthenticationUtils.isValidUserCrediential(crediantial)) {
    		//return 12 length token key & secret encoded with base64
    		//save the token to database
    		return tokenDAO.create(AuthenticationUtils.getToken(12));
    		//return AuthenticationUtils.getToken(12);
    	}else {
    		//return Response.status(Response.Status.NOT_FOUND).build();
    		throw new WebApplicationException(404);
    	}
    	
    }

}
