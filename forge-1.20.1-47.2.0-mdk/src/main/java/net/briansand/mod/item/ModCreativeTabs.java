package net.briansand.mod.item;

import net.briansand.mod.Main;
import net.briansand.mod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
			.create(Registries.CREATIVE_MODE_TAB, Main.MOD_ID);

	public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_TABS.register("mod_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.SAPPHIRE.get()))
					.title(Component.translatable("creativetab.mod_tab")).displayItems((pParameters, pOutput) -> {
						pOutput.accept(ModItem.SAPPHIRE.get());
						pOutput.accept(ModItem.RAW_SAPPHIRE.get());
						pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
	                    pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());


					}).build());



	public static void register(IEventBus eventBus) {
		CREATIVE_TABS.register(eventBus);
	}

}
