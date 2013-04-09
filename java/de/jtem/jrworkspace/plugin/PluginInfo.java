package de.jtem.jrworkspace.plugin;

import java.net.URL;

import javax.swing.Icon;

public class PluginInfo {
	
	/** The plug-in name */
	public String name = "unnamed";
	/** The vendor name of the plug-in */
	public String vendorName = "unknown";
	/** An email address of this plug-ins vendor */
	public String email = "unknown";
	/** An icon which will be the plug-ins icon 
	 *  in the application */
	public Icon icon = null;
	/** An URL to the Documentation of the plug-in. */
	public URL documentationURL = null;
	/** Indicates if this plug-in is meant to be dynamically 
	 *  installed or uninstalled */
	public boolean isDynamic = true;
	
	public PluginInfo() {
	}
	
	public PluginInfo(String name) {
		this.name = name;
	}
	
	public PluginInfo(String name, String vendor) {
		this(name);
		this.vendorName = vendor;
	}
	
	public static PluginInfo create(Class<?> pluginClass) {
		PluginInfo pi;
		if (pluginClass == null) {
			pi = new PluginInfo();
		} else {
			pi = new PluginInfo(pluginClass.getSimpleName());
		}
		if (pluginClass != null &&  pluginClass.getPackage() != null) {
			pi.vendorName = pluginClass.getPackage().getImplementationVendor();
		}
		return pi;
	}
	
}
