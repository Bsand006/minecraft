package net.briansand.mod;

import net.briansand.mod.item.ModItem;
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
	// public static final Logger LOGGER = (Logger) LogUtils.getLogger(); //
	// Initialize Logger

	public Main() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(); // Initialize event bus

		ModItem.register(modEventBus); // Register custom items

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

	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

		}

	}
}
