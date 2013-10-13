package com.abbink.gphoto_cli2j.command.expected;

import java.util.List;

import com.abbink.gphoto_cli2j.command.result.Config;
import com.google.common.collect.ImmutableList.Builder;
import com.google.inject.Provider;

public class ListConfigResult implements Provider<List<Config>> {
	
	public List<Config> get() {
		return new Builder<Config>()
				.add(Config.fromName("/main/actions/focuslock"))
				.add(Config.fromName("/main/actions/syncdatetime"))
				.add(Config.fromName("/main/settings/ownername"))
				.add(Config.fromName("/main/settings/capturetarget"))
				.add(Config.fromName("/main/settings/capture"))
				.add(Config.fromName("/main/status/model"))
				.add(Config.fromName("/main/status/firmwareversion"))
				.add(Config.fromName("/main/other/d001"))
				.add(Config.fromName("/main/other/d002"))
				.add(Config.fromName("/main/other/d003"))
				.add(Config.fromName("/main/other/d02c"))
				.add(Config.fromName("/main/other/d02d"))
				.add(Config.fromName("/main/other/d02e"))
				.add(Config.fromName("/main/other/d02f"))
				.add(Config.fromName("/main/other/d030"))
				.add(Config.fromName("/main/other/d031"))
				.add(Config.fromName("/main/other/d032"))
				.add(Config.fromName("/main/other/d033"))
				.add(Config.fromName("/main/other/d034"))
				.add(Config.fromName("/main/other/d045"))
				.add(Config.fromName("/main/other/d046"))
				.add(Config.fromName("/main/other/d047"))
				.add(Config.fromName("/main/other/d048"))
				.add(Config.fromName("/main/other/d049"))
				.add(Config.fromName("/main/other/d04b"))
				.build();
	}
	
}
