package mod.briansand.llama;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("branmod")
public class Llama {
	  
	private static final Logger LOGGER = LogManager.getLogger(); // Initialize logger

	    public Llama() { // Constructor 
	        LOGGER.info("Creating the mod...");
	    }
	    
	    // Declare event bus subscriber
	    @Mod.EventBusSubscriber(modid = "branmod", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
	    public static class RegistryEvents {
	        @SubscribeEvent
	        public static void onBlockBreak(BlockEvent.BreakEvent event) { // subscribes to block breaking event bus
	            LlamaEvents.onBlockBreak(event); // run onBlockBreak when event is triggered
	        }
	        
	        @SubscribeEvent
	        public static void onItemTaken(PlayerEvent.ItemPickupEvent event) {
	        	ItemEvents.onItemTaken(event);
	        }
	    }

}
