package com.abbink.gphoto_cli2j.command.testimpl;

import com.google.inject.Inject;

public class ListConfig extends com.abbink.gphoto_cli2j.command.ListConfig {
	
private CommandReplayer replayer;
	
	@Inject
	public ListConfig(com.abbink.gphoto_cli2j.command.parser.ListConfig parser, CommandReplayer replayer) {
		super(parser);
		this.replayer = replayer;
	}
	
	@Override
	protected String execute() {
		return replayer.replay(getCommand());
	}
	
}
