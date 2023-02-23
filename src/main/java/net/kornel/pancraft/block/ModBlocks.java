package net.kornel.pancraft.block;

import net.kornel.pancraft.PanCraft;
import net.kornel.pancraft.item.ModCreativeModeTab;
import net.kornel.pancraft.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PanCraft.MOD_ID);

    public static final RegistryObject<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> NITER_ORE = registerBlock("niter_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> DEEPSLATE_NITER_ORE = registerBlock("deepslate_niter_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.PANCRAFT_TAB);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, ()-> new BlockItem((block.get()), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
