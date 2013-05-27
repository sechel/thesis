package de.jtem.jrworkspace.plugin;

import java.util.List;

public interface Controller {

	public <T extends Plugin> T getPlugin(Class<T> clazz);
	public <T> List<T> getPlugins(Class<T> pClass);
	public Object storeProperty(Class<?> context, String key, Object property);
	public <T> T getProperty(Class<?> context, String key, T defaultValue);
	public <T> T deleteProperty(Class<?> context, String key);
	public boolean isActive(Plugin p);
	
}
