package com.abbink.gphoto_cli2j.command;

/**
 * A cli command
 * @param <T> the return type of the parsed command output
 */
public abstract class Command<T> {
	
	/**
	 * executes the cli command and parses its output
	 * @return parsed output
	 */
	public T run() {
		String ouput = execute();
		return parse(ouput);
	}
	
	/**
	 * executes the cli command and collects the output
	 * @return command's output
	 */
	protected abstract String execute();
	
	/**
	 * parses cli command's output
	 * @param ouput
	 * @return parsed output
	 */
	protected abstract T parse(String ouput);
}
