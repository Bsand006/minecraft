package minecraft.minecraftPlugins.Admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mute implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;

		if (player.isOp()) {
			if (args.length < 3) {
				player.sendMessage("ERROR: TOO FEW ARGUMENTS");
			} else if (args.length > 3) {
				player.sendMessage("ERROR: TOO MANY ARGUMENTS");
			} else {
				try {
					Player target = Bukkit.getPlayer(args[0]);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}

			}
		}

		return true;
	}
}
