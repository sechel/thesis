package de.sechel.thesis;

import de.jtem.jrworkspace.plugin.Controller;
import de.jtem.jrworkspace.plugin.Plugin;

public class MyPlugin extends Plugin {
	private DependentPlugin dependency = null;
	private double doubleState = 0.0;

	public void helloPlugin() {
		String depName = dependency.getPluginInfo().name;
		System.out.println("I am a plug-in. I depend on " + depName);
	}
	@Override
	public void storeStates(Controller c) throws Exception {
		c.storeProperty(MyPlugin.class, "doubleState", doubleState);
	}
	@Override
	public void restoreStates(Controller c) throws Exception {
		doubleState = c.getProperty(MyPlugin.class, "doubleState", 1.0);
	}
	@Override
	public void install(Controller c) throws Exception {
		dependency = c.getPlugin(DependentPlugin.class);
	}
}
