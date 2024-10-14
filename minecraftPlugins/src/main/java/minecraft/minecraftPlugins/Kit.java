  package minecraft.minecraftPlugins;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack birch = new ItemStack(Material.BIRCH_LOG);
			birch.setAmount(6);
			player.getInventory().addItem(birch);
		}
		return true;
	}

}