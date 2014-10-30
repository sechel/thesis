package de.sechel.thesis;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import de.jtem.jrworkspace.plugin.Controller;
import de.jtem.jrworkspace.plugin.aggregators.ToolBarAggregator;
import de.jtem.jrworkspace.plugin.flavor.PerspectiveFlavor;
import de.sechel.thesis.image.ImageHook;

public class MyToolBar extends ToolBarAggregator {

	private String[]
		testItems = {"Item 1", "Item 2", "Item 3"};
	
	@Override
	public Class<? extends PerspectiveFlavor> getPerspective() {
		return MyPerspective.class;
	}
	
	private class MyAction extends AbstractAction {
		
		private static final long serialVersionUID = 0L;

		public MyAction() {
			putValue(NAME, "My Action");
			putValue(SMALL_ICON, ImageHook.getIcon("exclam.png"));
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("My Action!");
		}
		
	}
	
	@Override
	public void install(Controller c) throws Exception {
		addAction(MyToolBar.class, 0.0, new MyAction());
		addTool(MyToolBar.class, 2.0, new JButton("Button"));
		addSeparator(MyToolBar.class, 1.0);
		addTool(MyToolBar.class, 3.0, new JCheckBox("Checker"));
		addTool(MyToolBar.class, 4.0, new JComboBox<Object>(testItems));
		addTool(MyToolBar.class, 5.0, new JButton("Button2"));
		super.install(c);
	}

}
