package minecraft.minecraftPlugins.listeners;

import java.sql.SQLException;
import java.util.Date;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import minecraft.minecraftPlugins.PlayerStats;
import minecraft.minecraftPlugins.SqlConnection;

public class Listeners implements Listener {

	private final SqlConnection database;

	public Listeners(SqlConnection database) {
		this.database = database;
	}

	// Get the stats of an existing player and create a stat table if they are new

	public PlayerStats getStats(Player player) throws SQLException {
		PlayerStats playerStats = database.findStats(player.getUniqueId().toString());

		// If the player is new

		if (playerStats == null) {
			playerStats = new PlayerStats(player.getUniqueId().toString(), 0, 0, 0, 0.0, new Date(), new Date());
			database.createStats(playerStats);
		}

		return playerStats;
	}

	// Update player login

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		try {
			PlayerStats stats = getStats(p);
			stats.setLastLogin(new Date());
			database.updateStats(stats);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update player logout

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		try {
			PlayerStats stats = getStats(p);
			stats.setLastLogout(new Date());
			database.updateStats(stats);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update blocks broken

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		try {
			PlayerStats stats = getStats(p);
			stats.setBlocksBroken(stats.getBlocksBroken() + 1);
			database.updateStats(stats);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update player death and players killed

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if (event.getEntity().getKiller() == null) { // Do nothing if death is not caused by another player
			return;
		}

		Player killer = event.getEntity().getKiller();
		Player killed = event.getEntity();

		try {
			PlayerStats killerStats = getStats(killer);
			PlayerStats killedStats = getStats(killed);
			killerStats.setKills(killerStats.getKills() + 1);
			killedStats.setDeaths(killedStats.getDeaths() + 1);
			database.updateStats(killerStats);
			database.updateStats(killedStats);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
