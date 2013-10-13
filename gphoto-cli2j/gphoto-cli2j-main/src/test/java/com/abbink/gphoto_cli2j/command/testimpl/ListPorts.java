package com.abbink.gphoto_cli2j.command.testimpl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Test implementation of {@link com.abbink.gphoto_cli2j.command.ListPorts}
 * Replays output using {@link CommandReplayer}
 */
@Singleton
public class ListPorts extends com.abbink.gphoto_cli2j.command.ListPorts {
	
	private CommandReplayer replayer;
	
	@Inject
	public ListPorts(com.abbink.gphoto_cli2j.command.parser.ListPorts parser, CommandReplayer replayer) {
		super(parser);
		this.replayer = replayer;
	}
	
	@Override
	protected String execute() {
		return replayer.replay(getCommand());
	}
	
}
