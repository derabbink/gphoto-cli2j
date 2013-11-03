package com.abbink.gphoto_cli2j.command;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URISyntaxException;
import java.util.List;

import com.abbink.gphoto_cli2j.command.arguments.CameraId;
import com.abbink.gphoto_cli2j.command.expected.ListConfigResult;
import com.abbink.gphoto_cli2j.command.expected.ListPortsResult;
import com.abbink.gphoto_cli2j.command.parser.CommandToOutput;
import com.abbink.gphoto_cli2j.command.result.ConfigId;
import com.abbink.gphoto_cli2j.command.result.Port;
import com.abbink.gphoto_cli2j.command.testimpl.CommandReplayer;
import com.google.guiceberry.GuiceBerryModule;
import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class TestCommandModule extends AbstractModule {
	
	@Override
	protected void configure() {
		install(new GuiceBerryModule());
		
		configureCommandReplayer();
		configureTestCommands();
		configureExpectedResults();
	}
	
	private void configureCommandReplayer() {
		bind(CommandToOutput.class);
		try {
			File mappingFile = new File(getClass().getClassLoader().getResource("command_outputs/commands.txt").toURI());
			bind(File.class).annotatedWith(Names.named("mappingFile")).toInstance(mappingFile);
		} catch (URISyntaxException e) {
			throw new Error("Could not create URI from mapping file URL", e);
		}
		
		bind(CommandReplayerProvider.class);
		bind(CommandReplayer.class).toProvider(CommandReplayerProvider.class);
	}
	
	private void configureTestCommands() {
		//ListPorts
		bind(com.abbink.gphoto_cli2j.command.ListPorts.class).to(com.abbink.gphoto_cli2j.command.testimpl.ListPorts.class);
		
		//ListConfig
		bind(com.abbink.gphoto_cli2j.command.ListConfig.class).to(com.abbink.gphoto_cli2j.command.testimpl.ListConfig.class);
		CameraId cameraId = new CameraId("usb:001,004", "Canon PowerShot A520 (PTP mode)");
		bind(CameraId.class).toInstance(cameraId);
	}
	
	private void configureExpectedResults() {
		bind(new TypeLiteral<List<Port>>() {}).annotatedWith(ExpectedResult.class).toProvider(ListPortsResult.class);
		bind(new TypeLiteral<List<ConfigId>>() {}).annotatedWith(ExpectedResult.class).toProvider(ListConfigResult.class);
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
	@BindingAnnotation
	public @interface ExpectedResult {}
}
