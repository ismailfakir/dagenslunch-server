package net.cloudcentrik.dagenslunch.auth;
import io.dropwizard.auth.Authorizer;
import net.cloudcentrik.dagenslunch.core.User;

public class AppAuthorizer implements Authorizer<User>{
	
	@Override
    public boolean authorize(User user, String role) {
        return user.getRoles() != null && user.getRoles().contains(role);
    }

}
