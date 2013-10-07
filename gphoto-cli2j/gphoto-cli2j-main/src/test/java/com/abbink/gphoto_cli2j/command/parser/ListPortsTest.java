package com.abbink.gphoto_cli2j.command.parser;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.abbink.gphoto_cli2j.command.result.Port;

/**
 * Tests for {@link com.abbink.gphoto_cli2j.command.parser.ListPorts}
 */
@RunWith(JUnit4.class)
public class ListPortsTest {
	
	@Test
	public void parsePortsFound() {
		String line = "Devices found: 3";
		int expected = 3;
		int actual = ListPorts.parsePortsFound(line);
		assertEquals(expected, actual);
	}
	
	@Test
	public void parsePort() {
		String line = "usb:001,004                      Universal Serial Bus";
		Port expected = Port.fromId("usb:001,004");
		Port actual = ListPorts.parsePort(line);
		assertEquals(expected, actual);
	}
	
}
