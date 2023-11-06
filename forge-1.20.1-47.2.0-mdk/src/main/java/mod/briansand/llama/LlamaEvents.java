package mod.briansand.llama;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.level.BlockEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LlamaEvents {
	private static final Logger LOGGER = LogManager.getLogger();

	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		LOGGER.info("A block was broken, spawning llamas...");

		BlockPos breakPosition = event.getPos(); // Gets coords of block that was broken
		// Create a vector with break coordinates
		Vec3 llamasPosition = new Vec3(breakPosition.getX(), breakPosition.getY(), breakPosition.getZ());

		Llama myNewLlama = new Llama(EntityType.LLAMA, (Level) event.getLevel()); // Create a new llama
		myNewLlama.setPos(llamasPosition); // Set the position of the llama at our vector
		event.getLevel().addFreshEntity(myNewLlama); // Add the llama
	}

}
