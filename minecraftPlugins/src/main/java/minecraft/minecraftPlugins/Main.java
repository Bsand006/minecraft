package minecraft.minecraftPlugins;

import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import minecraft.minecraftPlugins.listeners.Listeners;
import minecraft.minecraftPlugins.listeners.OnJoin;

public class Main extends JavaPlugin {

	private SqlConnection connection;

	@Override
	public void onEnable() {

		// Initialize the SQL connection

		this.connection = new SqlConnection();
		try {
			this.connection.initialize();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.getCommand("kit").setExecutor(new Kit());
		register();
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();

	}

	// Register the plugin manager and register OnJoin as an event to listen for a
	// player joining. Also register the listener for the SQL database.

	private void register() {
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new OnJoin(), this);
		getServer().getPluginManager().registerEvents(new Listeners(connection), this);
	}

}
