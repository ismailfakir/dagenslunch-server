package net.cloudcentrik.dagenslunch.auth;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import net.cloudcentrik.dagenslunch.core.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AppBasicAuthenticator implements Authenticator<BasicCredentials, User>{
	
	/*private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
	        "guest", ImmutableSet.of(),
	        "user", ImmutableSet.of("USER"),
	        DagenslunchCredential.USER_NAME,ImmutableSet.of(DagenslunchCredential.USER_ROLE),
	        "admin", ImmutableSet.of("ADMIN", "USER")
	    );*/
	
	private static final Map<String,String> VALID_USERS=new HashMap<String,String>();
	
	@Override 
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        /*if (VALID_USERS.containsKey(credentials.getUsername()) && DagenslunchCredential.USER_PASSWORD.equals(credentials.getPassword())) {
            return new User(credentials.getUsername(), VALID_USERS.get(credentials.getUsername());
        }*/
        return Optional.empty();
    }

}
