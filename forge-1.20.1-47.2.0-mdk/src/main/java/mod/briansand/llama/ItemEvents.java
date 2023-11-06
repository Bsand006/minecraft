package mod.briansand.llama;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ItemEvents {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void onItemTaken(PlayerEvent.ItemPickupEvent event) {
		ItemEntity item = event.getOriginalEntity();
		LOGGER.info("An item has been picked up!!!");

	}
}
