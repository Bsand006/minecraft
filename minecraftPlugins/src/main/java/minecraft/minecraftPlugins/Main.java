package minecraft.minecraftPlugins;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	List<String> banned = new ArrayList<String>();
	
	// Enables and initializes the /command plugin
	@Override
	public void onEnable() {
		this.getCommand("kit").setExecutor(new Kit());
		

		register();
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		
		
	}

	// Register the plugin manager and register OnJoin as an event to listen for

	private void register() {
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new OnJoin(), this);
	}

}
