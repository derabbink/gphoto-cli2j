package com.abbink.gphoto_cli2j.command.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.abbink.gphoto_cli2j.command.result.ConfigId;

/**
 * Tests for {@link com.abbink.gphoto_cli2j.command.parser.ListConfig}
 */
@RunWith(JUnit4.class)
public class ListConfigTest {
	
	@Test
	public void parseConfigName() {
		String line = "/main/settings/capturetarget";
		ConfigId expected = ConfigId.fromName("/main/settings/capturetarget");
		ConfigId actual = ListConfig.parseConfigName(line);
		assertEquals(expected, actual);
	}
	
}
