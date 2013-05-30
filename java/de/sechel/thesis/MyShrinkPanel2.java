package de.sechel.thesis;

import java.awt.GridLayout;

import javax.swing.JRadioButton;

import de.jtem.jrworkspace.plugin.sidecontainer.SideContainerPerspective;
import de.jtem.jrworkspace.plugin.sidecontainer.template.ShrinkPanelPlugin;

public class MyShrinkPanel2 extends ShrinkPanelPlugin {

	public MyShrinkPanel2() {
		shrinkPanel.setTitle("My Panel 2");
		shrinkPanel.setLayout(new GridLayout(3, 1));
		shrinkPanel.add(new JRadioButton("Radio 1"));
		shrinkPanel.add(new JRadioButton("Radio 2"));
		shrinkPanel.add(new JRadioButton("Radio 3"));
	}
	
	@Override
	public Class<? extends SideContainerPerspective> getPerspectivePluginClass() {
		return MyPerspective.class;
	}
	
}
