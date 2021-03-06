package com.abbink.gphoto_cli2j.command.result;

public class Port {
	
	public static Port fromId(String id) {
		return new Port(id);
	}
	
	private String id;
	
	private Port(String id) {
		setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean equals(Object other) {
		if (other instanceof Port) {
			return id.equals(((Port) other).getId());
		}
		return false;
	}
}
