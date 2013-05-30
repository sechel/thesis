package de.sechel.thesis;

import java.awt.GridLayout;

import javax.swing.JLabel;

import de.jtem.jrworkspace.plugin.sidecontainer.SideContainerPerspective;
import de.jtem.jrworkspace.plugin.sidecontainer.template.ShrinkPanelPlugin;

public class MyShrinkPanel3 extends ShrinkPanelPlugin {

	public MyShrinkPanel3() {
		setInitialPosition(SHRINKER_BOTTOM);
		shrinkPanel.setTitle("My Bottom Panel");
		shrinkPanel.setLayout(new GridLayout(3, 1));
		shrinkPanel.add(new JLabel("A Bottom Panel"));
	}
	
	@Override
	public Class<? extends SideContainerPerspective> getPerspectivePluginClass() {
		return MyPerspective.class;
	}
	
}
