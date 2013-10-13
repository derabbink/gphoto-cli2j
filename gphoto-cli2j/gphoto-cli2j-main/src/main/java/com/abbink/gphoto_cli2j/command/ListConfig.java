package com.abbink.gphoto_cli2j.command;

import java.util.List;

import com.abbink.gphoto_cli2j.command.result.Config;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ListConfig extends Command<List<Config>> {
	
	@Inject
	public ListConfig(com.abbink.gphoto_cli2j.command.parser.ListConfig parser) {
		super(parser);
	}
	
	public String getCommand() {
		return "gphoto2 --port=\"usb:001,004\" --camera=\"Canon PowerShot A520 (PTP mode)\" --list-config";
	}
	
	protected String execute() {
		//TODO
		return null;
	}
}