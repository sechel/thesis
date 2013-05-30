package de.sechel.thesis;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import de.jtem.jrworkspace.plugin.Controller;
import de.jtem.jrworkspace.plugin.flavor.PerspectiveFlavor;
import de.jtem.jrworkspace.plugin.sidecontainer.SideContainerPerspective;

public class MyPerspective extends SideContainerPerspective implements PerspectiveFlavor, ActionListener {

	private JButton button = new JButton("Press Me");
	private MyPlugin p = null;
	
	public MyPerspective() {
		getContentPanel().setLayout(new GridLayout());
		getContentPanel().add(button);
		button.setPreferredSize(new Dimension(200, 80));
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		p.helloPlugin();
	}
	
	@Override
	public void install(Controller c) throws Exception {
		p = c.getPlugin(MyPlugin.class);
	}
	
	@Override
	public Icon getIcon() {
		return null;
	}
	@Override
	public String getTitle() {
		return "My Perspective";
	}
	@Override
	public void setVisible(boolean arg0) {
	}

}
