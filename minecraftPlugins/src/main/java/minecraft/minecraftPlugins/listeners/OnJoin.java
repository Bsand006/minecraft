package minecraft.minecraftPlugins.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent event) {
		if (event.getPlayer().hasPlayedBefore() == true) {
			event.getPlayer().sendMessage("Welcome to the server " + event.getPlayer().getName());
		} else {
			event.getPlayer().sendMessage("Welcome Back " + event.getPlayer().getName());
		}
	}
}