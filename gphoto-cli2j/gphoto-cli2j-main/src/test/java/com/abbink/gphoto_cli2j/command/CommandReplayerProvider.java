package com.abbink.gphoto_cli2j.command;

import java.io.File;

import com.abbink.gphoto_cli2j.command.parser.CommandToOutput;
import com.abbink.gphoto_cli2j.command.testimpl.CommandReplayer;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class CommandReplayerProvider implements Provider<CommandReplayer> {
	
	private File mappingFile;
	private CommandToOutput parser;
	
	@Inject
	public CommandReplayerProvider(
			@Named("mappingFile") File mappingFile,
			CommandToOutput parser) {
		this.mappingFile = mappingFile;
		this.parser = parser;
	}
	
	public CommandReplayer get() {
		return CommandReplayer.fromCommandMappingFile(mappingFile, parser);
	}
}
