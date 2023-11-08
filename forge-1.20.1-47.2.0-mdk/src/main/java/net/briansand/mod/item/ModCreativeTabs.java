package net.briansand.mod.item;

import net.briansand.mod.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabs {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
			.create(Registries.CREATIVE_MODE_TAB, Main.MOD_ID);

	public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_TABS.register("tutorial_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.SAPPHIRE.get()))
					.title(Component.translatable("creativetab.tutorial_tab")).displayItems((pParameters, pOutput) -> {
						pOutput.accept(ModItem.SAPPHIRE.get());
						pOutput.accept(ModItem.RAW_SAPPHIRE.get());

					}).build());
}
