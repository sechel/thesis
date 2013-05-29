package de.sechel.thesis;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import de.jtem.jrworkspace.plugin.Controller;
import de.jtem.jrworkspace.plugin.aggregators.MenuAggregator;
import de.jtem.jrworkspace.plugin.flavor.PerspectiveFlavor;
import de.jtem.jrworkspace.plugin.flavor.ShutdownFlavor;

public class MyMenuBar extends MenuAggregator implements ShutdownFlavor {

	private ShutdownListener
		shutdownListener = null;
	
	@Override
	public Class<? extends PerspectiveFlavor> getPerspective() {
		return MyPerspective.class;
	}

	private class QuitAction extends AbstractAction {
		
		private static final long serialVersionUID = 0L;

		public QuitAction() {
			putValue(NAME, "Quit");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			shutdownListener.shutdown();
		}
		
	}
	
	@Override
	public void install(Controller c) throws Exception {
		super.install(c);
		addMenu(MyMenuBar.class, 0.0, new JMenu("File"));
		addMenu(MyMenuBar.class, 1.0, new JMenu("Menu 2"));
		addMenuItem(MyMenuBar.class, 0.0, new QuitAction(), "File");
		addMenuItem(MyMenuBar.class, 0.0, new JCheckBoxMenuItem("Test Checker"), "Menu 2");
		addMenuItem(MyMenuBar.class, 0.0, new JRadioButtonMenuItem("Test Radio"), "Menu 3", "Sub Menu");
		addMenuItem(MyMenuBar.class, 0.0, new JMenuItem("Test Item"), "Menu 3");
		addMenuSeparator(MyMenuBar.class, 1.0, "Menu 3");
	}
	
	@Override
	public void setShutdownListener(ShutdownListener l) {
		this.shutdownListener = l;
	}
	
}
