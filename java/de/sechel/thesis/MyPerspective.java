package de.sechel.thesis;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.jtem.jrworkspace.plugin.Controller;
import de.jtem.jrworkspace.plugin.Plugin;
import de.jtem.jrworkspace.plugin.flavor.PerspectiveFlavor;

public class MyPerspective extends Plugin implements PerspectiveFlavor, ActionListener {

	private JPanel panel = new JPanel();
	private JButton button = new JButton("Press Me");
	private MyPlugin p = null;
	
	public MyPerspective() {
		panel.setLayout(new GridLayout());
		panel.add(button);
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
	public Component getCenterComponent() {
		return panel;
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
