package com.abbink.gphoto_cli2j.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.abbink.gphoto_cli2j.command.parser.CommandToOutput;
import static com.google.common.base.Preconditions.*;
import com.google.inject.Singleton;

@Singleton
public class CommandReplayer {
	
	private Map<String, File> command2OutputFileMap;
	
	protected CommandReplayer(Map<String, File> command2OutputFileMap) {
		this.command2OutputFileMap = command2OutputFileMap;
	}
	
	public static CommandReplayer fromCommandMappingFile(File mappingFile, CommandToOutput parser) {
		String mapping;
		try {
			mapping = fileToString(mappingFile);
		} catch (FileNotFoundException e) {
			throw new Error("Could not load command to output mapping file "+ mappingFile, e);
		}
		
		Map<String, String> parsedMap = parser.parse(mapping);
		Map<String, File> map = translateParsedMap(mappingFile.getParentFile(), parsedMap);
		return new CommandReplayer(map);
	}
	
	public String replay(String command) {
		File replayFile = command2OutputFileMap.get(command);
		if (replayFile == null)
			throw new NoSuchElementException("Command `"+ command +"` not available for replay.");
		try {
			return fileToString(replayFile);
		}
		catch (FileNotFoundException e) {
			throw new Error("Could not find replay file for command `"+ command +"` in location "+ replayFile, e);
		}
	}
	
	/**
	 * returns the contents of a file as a string
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	private static String fileToString(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return content;
	}
	
	/**
	 * translates the relative paths in a map to their definitive path objects
	 * @param baseDirectory
	 * @param parsedMap
	 * @return
	 */
	private static Map<String, File> translateParsedMap(File baseDirectory, Map<String, String> parsedMap) {
		checkArgument(baseDirectory.isDirectory());
		
		Map<String, File> map = new HashMap<String, File>();
		
		for(String comm : parsedMap.keySet()) {
			String fName = parsedMap.get(comm);
			File outputFile = new File(baseDirectory, fName);
			map.put(comm, outputFile);
		}
		return map;
	}
	
}
