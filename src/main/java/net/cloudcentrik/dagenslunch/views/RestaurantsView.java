package net.cloudcentrik.dagenslunch.views;

import java.util.List;

import io.dropwizard.views.View;
import net.cloudcentrik.dagenslunch.core.Restaurant;

public class RestaurantsView extends View{
	
	private final String name;
	private final List<Restaurant> restaurants;
	public RestaurantsView(List<Restaurant> restaurants) {
		super("restaurants.ftl");
		 this.name="Dagenslunch";  
	     this.restaurants=restaurants;
	}
	
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public String getName() {
		return name;
	}

}
