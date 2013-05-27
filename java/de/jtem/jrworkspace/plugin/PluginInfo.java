package de.jtem.jrworkspace.plugin;

import java.net.URL;

import javax.swing.Icon;

public class PluginInfo {
	
	public String name = "unnamed";
	public String vendorName = "unknown";
	public String email = "unknown";
	public Icon icon = null;
	public URL documentationURL = null;
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
