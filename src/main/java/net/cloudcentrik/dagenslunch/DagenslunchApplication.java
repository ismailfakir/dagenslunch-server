package net.cloudcentrik.dagenslunch;

import net.cloudcentrik.dagenslunch.auth.DagenslunchAuthenticateFilter;
import net.cloudcentrik.dagenslunch.core.People;
import net.cloudcentrik.dagenslunch.core.Restaurant;
import net.cloudcentrik.dagenslunch.core.Template;
import net.cloudcentrik.dagenslunch.core.Token;
import net.cloudcentrik.dagenslunch.core.User;

import net.cloudcentrik.dagenslunch.db.PeopleDAO;
import net.cloudcentrik.dagenslunch.db.RestaurantDAO;
import net.cloudcentrik.dagenslunch.db.TokenDAO;
import net.cloudcentrik.dagenslunch.health.TemplateHealthCheck;
import net.cloudcentrik.dagenslunch.resources.GrettingsResource;
import net.cloudcentrik.dagenslunch.resources.IndexResource;
import net.cloudcentrik.dagenslunch.resources.PeopleResource;
import net.cloudcentrik.dagenslunch.resources.PersonResource;
import net.cloudcentrik.dagenslunch.resources.RestaurantResource;
import net.cloudcentrik.dagenslunch.resources.TokenResource;

import java.util.Map;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class DagenslunchApplication extends Application<DagenslunchConfiguration> {
	public static void main(String[] args) throws Exception {
		new DagenslunchApplication().run(args);
	}

	private final HibernateBundle<DagenslunchConfiguration> hibernateBundle = new HibernateBundle<DagenslunchConfiguration>(
			People.class,Restaurant.class,Token.class) {
		@Override
		public DataSourceFactory getDataSourceFactory(DagenslunchConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	@Override
	public String getName() {
		return "dagenslunch";
	}

	@Override
	public void initialize(Bootstrap<DagenslunchConfiguration> bootstrap) {
		// Enable variable substitution with environment variables
		bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
				bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));

		bootstrap.addBundle(new MigrationsBundle<DagenslunchConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(DagenslunchConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
		bootstrap.addBundle(hibernateBundle);
		
		
		/* view bandle */
		bootstrap.addBundle(new ViewBundle<DagenslunchConfiguration>());
		
		//bootstrap.addBundle(new AssetsBundle("/app/", "/app","/index.html"));
		//bootstrap.addBundle(new AssetsBundle("/assets/", "/app", "index.html"));
		//bootstrap.addBundle(new AssetsBundle("//app/lib", "/app/lib", null, "lib"));
	    bootstrap.addBundle(new AssetsBundle("/public/","/public"));
	    bootstrap.addBundle(new AssetsBundle("/public/","/public","index.html"));
	    
	    /* form */
	    bootstrap.addBundle(new MultiPartBundle());
	
	}

	@Override
	public void run(DagenslunchConfiguration configuration, Environment environment) {
		
		//dao
		final PeopleDAO peopleDao = new PeopleDAO(hibernateBundle.getSessionFactory());
		final RestaurantDAO restaurantDao = new RestaurantDAO(hibernateBundle.getSessionFactory());
		final TokenDAO tokenDao = new TokenDAO(hibernateBundle.getSessionFactory());

		
        // index resource
		environment.jersey().register(new IndexResource(restaurantDao));
		environment.jersey().getResourceConfig().getEndpointsInfo();
		
		//token authentication
        environment.jersey().register(DagenslunchAuthenticateFilter.class);
        
		final Template template = configuration.buildTemplate();
		environment.healthChecks().register("template", new TemplateHealthCheck(template));
		
		//people resource
		environment.jersey().register(new PeopleResource(peopleDao));

		// restaurant Resource
		environment.jersey().register(new RestaurantResource(restaurantDao));

		//final GrettingsResource grettings = new GrettingsResource();
		//environment.jersey().register(grettings);
		
		//send token
		//final AccessResource tokenResource = new AccessResource();
		//environment.jersey().register(tokenResource);
		final TokenResource tokenResource = new TokenResource(tokenDao);
		environment.jersey().register(tokenResource);
		
		final PersonResource personResource=new PersonResource(peopleDao);
		environment.jersey().register(personResource);
		
	}
}
