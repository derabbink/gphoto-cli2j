package com.abbink.gphoto_cli2j.command;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import com.abbink.gphoto_cli2j.command.expected.ListPortsResult;
import com.abbink.gphoto_cli2j.command.parser.CommandToOutput;
import com.abbink.gphoto_cli2j.command.result.Port;
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
		bind(File.class).annotatedWith(Names.named("mappingFile")).toInstance(new File("resources/command_outputs/commands.txt"));
		bind(CommandReplayerProvider.class);
		bind(CommandReplayer.class).toProvider(CommandReplayerProvider.class);
	}
	
	private void configureTestCommands() {
		bind(ListPorts.class).to(TestListPorts.class);
	}
	
	private void configureExpectedResults() {
		bind(new TypeLiteral<List<Port>>() {}).annotatedWith(ExpectedResult.class).toProvider(ListPortsResult.class);
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
	@BindingAnnotation
	public @interface ExpectedResult {}
}
