package net.cloudcentrik.dagenslunch.views;

import io.dropwizard.views.View;

public class LoginView extends View{
	
	private final String name;
	public LoginView() {
        super("login.ftl");
        this.name="Dagenslunch";
    }
	public String getName() {
		return name;
	}
	

}
