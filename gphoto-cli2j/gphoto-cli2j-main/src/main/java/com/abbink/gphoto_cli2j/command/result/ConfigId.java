package com.abbink.gphoto_cli2j.command.result;

public class ConfigId {
	
	public static ConfigId fromName(String configName) {
		return new ConfigId(configName);
	}
	
	private String name;
	
	private ConfigId(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object other) {
		if (other instanceof ConfigId) {
			return name.equals(((ConfigId) other).getName());
		}
		return false;
	}
	
}
