package com.abbink.gphoto_cli2j.command;

import com.google.inject.AbstractModule;

public class CommandModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(ListPorts.class);
	}
	
}
