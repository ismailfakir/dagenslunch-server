package net.cloudcentrik.dagenslunch.api;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grettings {
	
	
	private HashMap<String,String> serverInfo;
	

	@JsonProperty
	public HashMap<String, String> getServerInfo() {
		return serverInfo;
	}

	public void setServerInfo(HashMap<String, String> serverInfo) {
		this.serverInfo = serverInfo;
	}

	public Grettings() {
		// TODO Auto-generated constructor stub
	}

	public Grettings(HashMap<String, String> serverInfo) {
		super();
		this.serverInfo = serverInfo;
	}
	

}
