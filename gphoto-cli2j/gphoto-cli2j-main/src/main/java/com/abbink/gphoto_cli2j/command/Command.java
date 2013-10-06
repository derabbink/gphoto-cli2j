package com.abbink.gphoto_cli2j.command;

import com.abbink.gphoto_cli2j.command.parser.Parser;

/**
 * A cli command
 * @param <T> the return type of the parsed command output
 */
public abstract class Command<T> {
	
	private Parser<T> parser;
	
	public Command(Parser<T> parser) {
		setParser(parser);
	}
	
	private void setParser(Parser<T> parser) {
		this.parser = parser;
	}
	
	protected Parser<T> getPartser() {
		return parser;
	}
	
	/**
	 * executes the cli command and parses its output
	 * @return parsed output
	 */
	public T run() {
		String ouput = execute();
		return parser.parse(ouput);
	}
	
	/**
	 * return the cli command for this Command object
	 * @return
	 */
	public abstract String getCommand();
	
	/**
	 * executes the cli command and collects the output
	 * @return command's output
	 */
	protected abstract String execute();
}
