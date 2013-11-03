package com.abbink.gphoto_cli2j.command;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.abbink.gphoto_cli2j.command.TestCommandModule.ExpectedResult;
import com.abbink.gphoto_cli2j.command.arguments.CameraId;
import com.abbink.gphoto_cli2j.command.result.ConfigId;
import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;

/**
 * Tests for {@link com.abbink.gphoto_cli2j.command.ListConfig}
 */
@RunWith(JUnit4.class)
public class ListConfigTest {
	
	@Rule
	public final GuiceBerryRule guiceBerry = new GuiceBerryRule(TestCommandModule.class);
	
	@Inject
	private ListConfig command;
	
	@Inject
	private CameraId args;
	
	@Inject
	@ExpectedResult
	private List<ConfigId> expected;
	
	@Test
	public void successfulCommand() {
		List<ConfigId> actual  = command.run(args);
		assertEquals(expected, actual);
	}
	
}
