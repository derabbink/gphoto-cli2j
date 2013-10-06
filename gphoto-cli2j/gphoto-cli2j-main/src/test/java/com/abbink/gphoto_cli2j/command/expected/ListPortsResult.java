package com.abbink.gphoto_cli2j.command.expected;

import java.util.List;

import com.abbink.gphoto_cli2j.command.result.Port;
import com.google.common.collect.ImmutableList.Builder;
import com.google.inject.Provider;

public class ListPortsResult implements Provider<List<Port>> {
	
	public List<Port> get() {
		return new Builder<Port>()
				.add(Port.fromId("ptpip:"))
				.add(Port.fromId("usb:001,004"))
				.add(Port.fromId("usb:001,003"))
				.build();
	}
	
}
