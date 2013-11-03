package com.abbink.gphoto_cli2j.command;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.abbink.gphoto_cli2j.command.parser.Parser;

/**
 * A cli command that requires some arguments
 * @param <TArgs> the type of arguments supplied to the command
 * @param <TResult> the return type of the parsed command output
 */
public abstract class CommandWithArgs<TArgs, TResult> extends Command<TResult> {

	public CommandWithArgs(Parser<TResult> parser) {
		super(parser);
	}
	
	/**
	 * Does not do anything
	 * @deprecated Use {@link #run(TArgs)}
	 * @return null
	 */
	@Deprecated
	public TResult run() {
		return null;
	}
	
	/**
	 * executes the cli command and parses its output
	 * @param args Arguments required in the command 
	 * @return Parsed output
	 */
	public TResult run(TArgs args) {
		String ouput = execute(args);
		return getParser().parse(ouput);
	}
	
	/**
	 * Does not do anything
	 * @deprecated Use {@link #execute(TArgs)}
	 * @return null
	 */
	@Deprecated
	protected String execute() {
		return null;
	}
	
	/**
	 * executes the cli command and collects the output
	 * @param args Arguments required in the command
	 * @return command's output
	 */
	protected String execute(TArgs args) {
		throw new NotImplementedException();
	}

}
