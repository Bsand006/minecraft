package net.briansand.mod.item;

import net.briansand.mod.Main;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID); // Initialize register

	public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", // Create Sapphire object
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", // Create raw Sapphire object
			() -> new Item(new Item.Properties()));

	public static void register(IEventBus eventBus) { // Register Sapphire objects
		ITEMS.register(eventBus);
	}
}
