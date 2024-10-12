package minecraft.minecraftPlugins;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	// Enables and initializes the /command plugin

	@Override
	public void onEnable() {
		this.getCommand("kit").setExecutor(new Plugin());

		register();
	}

	// Register the plugin manager and register OnJoin as an event to listen for

	private void register() {
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new OnJoin(), this);
	}

}
