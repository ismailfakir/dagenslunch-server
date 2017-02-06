package net.cloudcentrik.dagenslunch;

import net.cloudcentrik.dagenslunch.core.Person;
import net.cloudcentrik.dagenslunch.core.Restaurant;
import net.cloudcentrik.dagenslunch.core.Template;
import net.cloudcentrik.dagenslunch.db.PersonDAO;
import net.cloudcentrik.dagenslunch.db.RestaurantDAO;
import net.cloudcentrik.dagenslunch.health.TemplateHealthCheck;
import net.cloudcentrik.dagenslunch.resources.GrettingsResource;
import net.cloudcentrik.dagenslunch.resources.PeopleResource;
import net.cloudcentrik.dagenslunch.resources.RestaurantResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DagenslunchApplication extends Application<DagenslunchConfiguration> {
	public static void main(String[] args) throws Exception {
		new DagenslunchApplication().run(args);
	}

	private final HibernateBundle<DagenslunchConfiguration> hibernateBundle = new HibernateBundle<DagenslunchConfiguration>(
			Person.class,Restaurant.class) {
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
	
	}

	@Override
	public void run(DagenslunchConfiguration configuration, Environment environment) {
		final PersonDAO dao = new PersonDAO(hibernateBundle.getSessionFactory());
		final RestaurantDAO restaurantDao = new RestaurantDAO(hibernateBundle.getSessionFactory());

		final Template template = configuration.buildTemplate();
		environment.healthChecks().register("template", new TemplateHealthCheck(template));
		environment.jersey().register(new PeopleResource(dao));

		// restaurant Resource
		environment.jersey().register(new RestaurantResource(restaurantDao));

		final GrettingsResource grettings = new GrettingsResource();
		environment.jersey().register(grettings);

	}
}
