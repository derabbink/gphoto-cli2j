package com.abbink.gphoto_cli2j.command;

import com.abbink.gphoto_cli2j.command.arguments.CameraIdAndConfigId;
import com.abbink.gphoto_cli2j.command.result.Config;
import com.google.inject.Inject;

public class GetConfig extends CommandWithArgs<CameraIdAndConfigId, Config> {
	
	@Inject
	public GetConfig(com.abbink.gphoto_cli2j.command.parser.GetConfig parser) {
		super(parser);
	}
	
	public String getCommand(CameraIdAndConfigId args) {
		return "gphoto2 --port=\""+ args.getCameraId().getPort() +
				"\" --camera=\""+ args.getCameraId().getCameraName() +
				"\" --get-config "+ args.getConfigId().getName();
	}
	
	protected String execute() {
		//TODO
		return null;
	}
	
}
