package de.sechel.thesis;

import static de.jtem.jrworkspace.plugin.simplecontroller.SimpleController.PropertiesMode.StaticPropertiesFile;

import java.io.File;

import javax.swing.UIManager;

import de.jtem.jrworkspace.plugin.simplecontroller.SimpleController;

public class MyApplication {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SimpleController c = new SimpleController("My Application");
		c.setManageLookAndFeel(false);
		c.setPropertiesMode(StaticPropertiesFile);
		c.setStaticPropertiesFile(new File("MyApp.xml"));
		c.registerPlugin(MyPerspective.class);
		c.registerPlugin(MyMenuBar.class);
		c.registerPlugin(MyToolBar.class);
		c.registerPlugin(MyShrinkPanel.class);
		c.registerPlugin(MyShrinkPanel2.class);
		c.registerPlugin(MyShrinkPanel3.class);
		c.registerPlugin(MyShrinkPanel4.class);
		c.startup();
	}

}
