package com.abbink.gphoto_cli2j.command;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Test implementation of {@link ListPorts}
 * Replays output using {@link CommandReplayer}
 */
@Singleton
public class TestListPorts extends ListPorts {
	
	private CommandReplayer replayer;
	
	@Inject
	public TestListPorts(com.abbink.gphoto_cli2j.command.parser.ListPorts parser, CommandReplayer replayer) {
		super(parser);
		this.replayer = replayer;
	}
	
	@Override
	protected String execute() {
		return replayer.replay(getCommand());
	}
	
}
