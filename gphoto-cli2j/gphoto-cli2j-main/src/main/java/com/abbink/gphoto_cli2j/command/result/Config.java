package com.abbink.gphoto_cli2j.command.result;

public class Config {
	
	public static Config fromName(String configName) {
		return new Config(configName);
	}
	
	private String name;
	
	private Config(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object other) {
		if (other instanceof Config) {
			return name.equals(((Config) other).getName());
		}
		return false;
	}
	
}
