package com.abbink.gphoto_cli2j.command;

import java.util.List;

import com.abbink.gphoto_cli2j.command.arguments.CameraId;
import com.abbink.gphoto_cli2j.command.result.Config;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ListConfig extends CommandWithArgs<CameraId, List<Config>> {
	
	@Inject
	public ListConfig(com.abbink.gphoto_cli2j.command.parser.ListConfig parser) {
		super(parser);
	}
	
	public String getCommand(CameraId args) {
		return "gphoto2 --port=\""+ args.getPort() + "\" --camera=\""+ args.getCameraName() + "\" --list-config";
	}
	
	protected String execute() {
		//TODO
		return null;
	}
}