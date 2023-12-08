package net.briansand.branmod.blocks;

import java.util.function.Supplier;

import net.briansand.branmod.Main;
import net.briansand.branmod.item.ModItem;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/*
 * Fields:
 * 
 * Blockbehaviour.Properties.strength() - How long it takes to break block. STONE = 1f
 * Blockbehaviour.Properties.requiresCorrectToolForDrops() - Specifies specific tool is required. Set in data.minecraft.tags.blocks and data.minecraft.tags.blocks.mineable
 * UniformInt.of(int, int) - Sets value of experience dropped for mining block. Specific to DropExperienceBlock type
 */

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID); // Initialize block register
																														

	public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

	public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

	public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
			() -> new DropExperienceBlock(
					BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops(),
					UniformInt.of(3, 7)));

	public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
			() -> new DropExperienceBlock(
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f).requiresCorrectToolForDrops(),
					UniformInt.of(5, 8)));

	// Register custom blocks
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block); // Register block
		registerBlockItem(name, toReturn); // Register block item
		return toReturn;
	}

	// Register custom item to custom block
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

}
