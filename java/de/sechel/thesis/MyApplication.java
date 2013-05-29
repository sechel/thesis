package de.sechel.thesis;

import javax.swing.UIManager;

import de.jtem.jrworkspace.plugin.simplecontroller.SimpleController;

public class MyApplication {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SimpleController c = new SimpleController("My Application");
		c.setManageLookAndFeel(false);
		c.registerPlugin(MyPerspective.class);
		c.registerPlugin(MyMenuBar.class);
		c.registerPlugin(MyToolBar.class);
		c.startup();
	}

}
