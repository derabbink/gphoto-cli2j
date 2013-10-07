package com.abbink.gphoto_cli2j.command;

import java.util.List;

import com.abbink.gphoto_cli2j.command.result.Port;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ListPorts extends Command<List<Port>> {
	
	@Inject
	public ListPorts(com.abbink.gphoto_cli2j.command.parser.ListPorts parser) {
		super(parser);
	}
	
	public String getCommand() {
		return "gphoto2 --list-ports";
	}
	
	protected String execute() {
		//TODO
		return null;
	}
	
}
