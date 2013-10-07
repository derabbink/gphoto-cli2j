package com.abbink.gphoto_cli2j.command.parser;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.inject.Singleton;

@Singleton
public class CommandToOutput extends Parser<Map<String, String>> {
	
	/**
	 * two patterns (.*) separated by \t
	 * first pattern must not begin with a #
	 */
	public static final Pattern linePattern = Pattern.compile("^((?!#).*)\\t(.*)$");
	
	@Override
	public Map<String, String> parse(String raw) {
		Map<String, String> result = new HashMap<String, String>();
		
		Scanner scanner = new Scanner(raw);
		Scanner lineScanner = scanner.useDelimiter("\n");
		while (lineScanner.hasNext()) {
			try {
				Matcher matcher = matchLine(lineScanner.next());
				Entry<String, String> line = readLine(matcher);
				result.put(line.getKey(), line.getValue());
			}
			catch (IllegalStateException e) {
				//line not valid, skip over
			}
		}
		scanner.close();
		return result;
	}
	
	/**
	 * Creates a Matcher based on {@link #linePattern} for line 
	 * @param line
	 * @return Matcher ready to be consumed using {@link Matcher#group(int)}
	 */
	static Matcher matchLine(String line) {
		Matcher result = linePattern.matcher(line);
		result.find();
		return result;
	}
	
	/**
	 * Extracts command and mapped file from matcher
	 * @param matcher on which {@link Matcher#find()} has already been applied
	 * @return combination of parsed command and output file
	 * @throws IllegalStateException if the line could not be parsed (e.g. when it's uncommented)
	 */
	static Entry<String, String> readLine(Matcher matcher) {
		String command = matcher.group(1);
		String outputFile = matcher.group(2);
		return new AbstractMap.SimpleEntry<String, String>(command, outputFile);
	}
	
}
