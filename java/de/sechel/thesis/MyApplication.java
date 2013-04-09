package de.sechel.thesis;

import de.jtem.jrworkspace.plugin.simplecontroller.SimpleController;

public class MyApplication {

	public static void main(String[] args) {
		SimpleController c = new SimpleController("My Application");
		c.registerPlugin(MyPerspective.class);
		c.startup();
	}

}
