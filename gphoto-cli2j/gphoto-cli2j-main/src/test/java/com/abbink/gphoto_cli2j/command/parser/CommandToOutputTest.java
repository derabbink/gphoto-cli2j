package com.abbink.gphoto_cli2j.command.parser;

import static org.junit.Assert.assertEquals;

import java.util.Map.Entry;
import java.util.regex.Matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link com.abbink.gphoto_cli2j.command.parser.CommandToOutput}
 */
@RunWith(JUnit4.class)
public class CommandToOutputTest {
	
	@Test
	public void matchLine() {
		String line = "abc	def";
		Matcher matcher = CommandToOutput.matchLine(line);
		
		String found = matcher.group(1);
		assertEquals("abc", found);
		found = matcher.group(2);
		assertEquals("def", found);
	}
	
	@Test(expected = IllegalStateException.class)
	public void matchUncommentedLine() {
		String line = "#abc	def";
		Matcher matcher = CommandToOutput.matchLine(line);
		
		//throws:
		matcher.group();
	}
	
	@Test
	public void readLine() {
		String line = "abc	def";
		Matcher matcher = CommandToOutput.matchLine(line);
		Entry<String, String> parsedLine = CommandToOutput.readLine(matcher);
		
		assertEquals("abc", parsedLine.getKey());
		assertEquals("def", parsedLine.getValue());
	}
	
	@Test(expected = IllegalStateException.class)
	public void readUncommentedLine() {
		String line = "#abc	def";
		Matcher matcher = CommandToOutput.matchLine(line);
		//throws:
		CommandToOutput.readLine(matcher);
	}
}
