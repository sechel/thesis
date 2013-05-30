package de.sechel.thesis;

import java.awt.GridLayout;

import javax.swing.JLabel;

import de.jtem.jrworkspace.plugin.sidecontainer.SideContainerPerspective;
import de.jtem.jrworkspace.plugin.sidecontainer.template.ShrinkPanelPlugin;
import de.sechel.thesis.image.ImageHook;

public class MyShrinkPanel4 extends ShrinkPanelPlugin {

	public MyShrinkPanel4() {
		shrinkPanel.setTitle("My Icon Panel");
		shrinkPanel.setIcon(ImageHook.getIcon("helpred.png"));
		shrinkPanel.setLayout(new GridLayout(3, 1));
		shrinkPanel.add(new JLabel("Shrink Panel"));
	}
	
	@Override
	public Class<? extends SideContainerPerspective> getPerspectivePluginClass() {
		return MyPerspective.class;
	}
	
}
