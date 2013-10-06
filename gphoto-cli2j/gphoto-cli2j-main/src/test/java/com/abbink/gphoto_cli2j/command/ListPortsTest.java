package com.abbink.gphoto_cli2j.command;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.abbink.gphoto_cli2j.command.TestCommandModule.ExpectedResult;
import com.abbink.gphoto_cli2j.command.result.Port;
import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;

/**
 * Tests for {@link com.abbink.gphoto_cli2j.command.ListPorts}
 */
@RunWith(JUnit4.class)
public class ListPortsTest {
	
	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(TestCommandModule.class);
	
	@Inject
	private ListPorts command;
	
	@Inject
	@ExpectedResult
	private List<Port> expected;
	
	@Test
	public void successfulCommand() {
		List<Port> actual  = command.run();
		assertEquals(expected, actual);
	}
	
}
