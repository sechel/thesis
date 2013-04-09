package de.jtem.jrworkspace.plugin;

public abstract class Plugin {

	public PluginInfo getPluginInfo() {
		return PluginInfo.create(getClass());
	}
	
	public void install(Controller c) throws Exception{}
	
	public void uninstall(Controller c) throws Exception {}
	
	public void restoreStates(Controller c) throws Exception {}
	
	public void storeStates(Controller c) throws Exception {}
	
	@Override
	public String toString() {
		if (getPluginInfo().name == null) {
			return "No Name";
		} else {
			return getPluginInfo().name;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			return getClass().equals(obj.getClass());
		}
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
}
