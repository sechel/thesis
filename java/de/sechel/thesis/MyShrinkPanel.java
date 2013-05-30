package de.sechel.thesis;

import java.awt.GridLayout;

import javax.swing.JButton;

import de.jtem.jrworkspace.plugin.sidecontainer.SideContainerPerspective;
import de.jtem.jrworkspace.plugin.sidecontainer.template.ShrinkPanelPlugin;

public class MyShrinkPanel extends ShrinkPanelPlugin {

	public MyShrinkPanel() {
		shrinkPanel.setTitle("My Panel");
		shrinkPanel.setLayout(new GridLayout(3, 1));
		shrinkPanel.add(new JButton("Button 1"));
		shrinkPanel.add(new JButton("Button 2"));
		shrinkPanel.add(new JButton("Button 3"));
	}
	
	@Override
	public Class<? extends SideContainerPerspective> getPerspectivePluginClass() {
		return MyPerspective.class;
	}
	
}
