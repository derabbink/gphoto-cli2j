package com.abbink.gphoto_cli2j.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import com.abbink.gphoto_cli2j.command.expected.ListPortsResult;
import com.abbink.gphoto_cli2j.command.result.Port;
import com.google.guiceberry.GuiceBerryModule;
import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.TypeLiteral;

public class TestCommandModule extends AbstractModule {
	
	@Override
	protected void configure() {
		install(new GuiceBerryModule());
		
		configureTestCommands();
		configureExpectedResults();
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
