package com.abbink.gphoto_cli2j.command.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.abbink.gphoto_cli2j.command.result.Config;
import com.abbink.gphoto_cli2j.command.result.Port;

public class ListConfig extends Parser<List<Config>> {
	
	/**
	 * matches any non-empty string
	 */
	public static final Pattern configNameLinePattern = Pattern.compile("^(.+)$");
	
	public List<Config> parse(String raw) {
		List<Config> result = new LinkedList<Config>();
		
		Scanner scanner = new Scanner(raw);
		Scanner lineScanner = scanner.useDelimiter("\n");
		
		while (lineScanner.hasNext()) {
			String line = lineScanner.next();
			try {
				result.add(parseConfigName(line));
			}
			catch (IllegalStateException e) {
				scanner.close();
				throw new Error("Could not read a found config name", e);
			}
		}
		
		scanner.close();
		return result;
	}
	
	/**
	 * Parses a line like "/main/settings/capturetarget"
	 * @param line input to parse
	 * @return the port identified by the port's id
	 * @throws IllegalStateException if the line could not be parsed
	 */
	public static Config parseConfigName(String line) {
		Matcher matcher = configNameLinePattern.matcher(line);
		matcher.find();
		return Config.fromName(matcher.group(1));
	}
}
