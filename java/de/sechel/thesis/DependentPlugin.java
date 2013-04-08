package de.sechel.thesis;

import de.jtem.jrworkspace.plugin.Controller;
import de.jtem.jrworkspace.plugin.Plugin;

public class DependentPlugin extends Plugin {

	private double
		doubleState = 0.0;
	
	@Override
	public void storeStates(Controller c) throws Exception {
		c.storeProperty(DependentPlugin.class, "doubleState", doubleState);
	}

	@Override
	public void restoreStates(Controller c) throws Exception {
		doubleState = c.getProperty(DependentPlugin.class, "doubleState", 1.0);
	}
	
	@Override
	public void install(Controller c) throws Exception {
	}

	@Override
	public void uninstall(Controller c) throws Exception {
	}
	
}
