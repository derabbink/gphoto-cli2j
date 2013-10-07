package com.abbink.gphoto_cli2j.command.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.abbink.gphoto_cli2j.command.result.Port;

public class ListPorts extends Parser<List<Port>> {
	
	/**
	 * matches the number after "Devices found: "
	 */
	public static final Pattern portsFoundLinePattern = Pattern.compile("^Devices found: (\\d+)$");
	
	/**
	 * matches the name at the beginning of a line; all before any spaces
	 */
	public static final Pattern portLinePattern = Pattern.compile("^([^ ]+).+$");
	
	public List<Port> parse(String raw) {
		List<Port> result = new LinkedList<Port>();
		
		Scanner scanner = new Scanner(raw);
		Scanner lineScanner = scanner.useDelimiter("\n");
		
		int portsFound = 0;
		int i = 0;
		while (lineScanner.hasNext()) {
			String line = lineScanner.next();
			if (i == 0) {
				try {
					portsFound = parsePortsFound(line);
				}
				catch (IllegalStateException e) {
					scanner.close();
					throw new Error("Could not read number of found devices", e);
				}
			}
			else if (i > 2) {
				try {
					result.add(parsePort(line));
				}
				catch (IllegalStateException e) {
					scanner.close();
					throw new Error("Could not read a found device", e);
				}
			}
			i++;
		}
		
		scanner.close();
		return result;
	}
	
	/**
	 * Parses a line like "Devices found: 3"
	 * @param line input to parse
	 * @return the number of found devices as indicated in the input line
	 * @throws IllegalStateException if the line could not be parsed
	 */
	public static int parsePortsFound(String line) {
		Matcher matcher = portsFoundLinePattern.matcher(line);
		matcher.find();
		return Integer.parseInt(matcher.group(1));
	}
	
	/**
	 * Parses a line like "usb:001,002    Universal Serial Bus"
	 * @param line input to parse
	 * @return the port identified by the port's id
	 * @throws IllegalStateException if the line could not be parsed
	 */
	public static Port parsePort(String line) {
		Matcher matcher = portLinePattern.matcher(line);
		matcher.find();
		return Port.fromId(matcher.group(1));
	}
}
