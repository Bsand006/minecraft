package net.briansand.mod.blocks;

import java.util.function.Supplier;

import net.briansand.mod.Main;
import net.briansand.mod.item.ModItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID); // Initialize register

	public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
	
	  public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
	            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
	  
	  
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
