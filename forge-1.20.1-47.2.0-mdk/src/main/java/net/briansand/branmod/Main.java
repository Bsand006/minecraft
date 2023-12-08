package net.briansand.branmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.briansand.branmod.blocks.ModBlocks;
import net.briansand.branmod.item.ModCreativeTabs;
import net.briansand.branmod.item.ModItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class Main {

	public static final String MOD_ID = "branmod"; // Declare MODID
	public static final Logger LOGGER = LogManager.getLogger(); // Initialize Logger

	public Main() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(); // Initialize event bus

		ModCreativeTabs.register(modEventBus); // Register custom tab
		ModItem.register(modEventBus); // Register custom items
		ModBlocks.register(modEventBus); // Register custom blocks 

		modEventBus.addListener(this::commonSetup); // Add event bus to listener
		MinecraftForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::addCreative);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {

	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) { // Add custom items to INGREDIENTS creative mode
																		// tab menu event
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) { // If INGREDIENTS tab
			event.accept(ModItem.SAPPHIRE); // Accept Sapphire event
			event.accept(ModItem.RAW_SAPPHIRE); // Accept raw Sapphire event
		}
	}

	// Register all static methods in classes with @subscribeEvent tag. Not currently using this.
	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {

		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

		}

	}
}
