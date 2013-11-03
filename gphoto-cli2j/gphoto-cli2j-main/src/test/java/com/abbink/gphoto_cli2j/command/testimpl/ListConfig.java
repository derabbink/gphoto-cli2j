package com.abbink.gphoto_cli2j.command.testimpl;

import com.abbink.gphoto_cli2j.command.arguments.CameraId;
import com.google.inject.Inject;

public class ListConfig extends com.abbink.gphoto_cli2j.command.ListConfig {
	
	private CommandReplayer replayer;
	
	@Inject
	public ListConfig(com.abbink.gphoto_cli2j.command.parser.ListConfig parser, CommandReplayer replayer) {
		super(parser);
		this.replayer = replayer;
	}
	
	@Override
	protected String execute(CameraId args) {
		return replayer.replay(getCommand(args));
	}
	
}
