package com.abbink.gphoto_cli2j.command.parser;

/**
 * parses command output and produces usable objects 
 * @param <T> type of parsed data
 */
public abstract class Parser<T> {
	
	/**
	 * turns command output into data object
	 * @param raw command's output
	 * @return parsed command output
	 */
	public abstract T parse(String raw);
	
}
