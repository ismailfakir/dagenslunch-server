package net.cloudcentrik.dagenslunch.views;

import io.dropwizard.views.View;
import net.cloudcentrik.dagenslunch.utils.DagenslunchUtils;

public class IndexView extends View {

	private final String name;
	private final String user;

	public IndexView(String user) {
		super("index.ftl");

		this.name = DagenslunchUtils.APPLICATION_NAME;
		this.user = user;

	}

	public String getName() {
		return name;
	}

	public String getUser() {
		return user;
	}

}