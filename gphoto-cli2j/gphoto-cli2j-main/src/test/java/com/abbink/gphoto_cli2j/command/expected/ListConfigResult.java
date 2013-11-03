package com.abbink.gphoto_cli2j.command.expected;

import java.util.List;

import com.abbink.gphoto_cli2j.command.result.ConfigId;
import com.google.common.collect.ImmutableList.Builder;
import com.google.inject.Provider;

public class ListConfigResult implements Provider<List<ConfigId>> {
	
	public List<ConfigId> get() {
		return new Builder<ConfigId>()
				.add(ConfigId.fromName("/main/actions/focuslock"))
				.add(ConfigId.fromName("/main/actions/syncdatetime"))
				.add(ConfigId.fromName("/main/settings/ownername"))
				.add(ConfigId.fromName("/main/settings/capturetarget"))
				.add(ConfigId.fromName("/main/settings/capture"))
				.add(ConfigId.fromName("/main/status/model"))
				.add(ConfigId.fromName("/main/status/firmwareversion"))
				.add(ConfigId.fromName("/main/other/d001"))
				.add(ConfigId.fromName("/main/other/d002"))
				.add(ConfigId.fromName("/main/other/d003"))
				.add(ConfigId.fromName("/main/other/d02c"))
				.add(ConfigId.fromName("/main/other/d02d"))
				.add(ConfigId.fromName("/main/other/d02e"))
				.add(ConfigId.fromName("/main/other/d02f"))
				.add(ConfigId.fromName("/main/other/d030"))
				.add(ConfigId.fromName("/main/other/d031"))
				.add(ConfigId.fromName("/main/other/d032"))
				.add(ConfigId.fromName("/main/other/d033"))
				.add(ConfigId.fromName("/main/other/d034"))
				.add(ConfigId.fromName("/main/other/d045"))
				.add(ConfigId.fromName("/main/other/d046"))
				.add(ConfigId.fromName("/main/other/d047"))
				.add(ConfigId.fromName("/main/other/d048"))
				.add(ConfigId.fromName("/main/other/d049"))
				.add(ConfigId.fromName("/main/other/d04b"))
				.build();
	}
	
}
