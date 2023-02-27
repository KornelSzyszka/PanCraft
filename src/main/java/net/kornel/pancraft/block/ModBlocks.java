package net.kornel.pancraft.block;

import net.kornel.pancraft.PanCraft;
import net.kornel.pancraft.block.custom.ModFlammableRotatedPillarBlock;
import net.kornel.pancraft.item.ModCreativeModeTab;
import net.kornel.pancraft.item.ModItems;
import net.kornel.pancraft.world.feature.tree.HeveaTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PanCraft.MOD_ID);

    public static final RegistryObject<Block> SULFUR_BLOCK = registerBlock("sulfur_block",
            ()->new Block(BlockBehaviour.Properties.of(Material.SNOW).strength(1)), ModCreativeModeTab.PANCRAFT_TAB);

    public static final RegistryObject<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops(),
                    UniformInt.of(1,3)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops(),
                    UniformInt.of(1,3)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> NETHER_SULFUR_ORE = registerBlock("nether_sulfur_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops(),
                    UniformInt.of(1,3)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> NITER_ORE = registerBlock("niter_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops(),
                    UniformInt.of(1,3)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> DEEPSLATE_NITER_ORE = registerBlock("deepslate_niter_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2).requiresCorrectToolForDrops(),
                    UniformInt.of(1,3)), ModCreativeModeTab.PANCRAFT_TAB);

    public static final RegistryObject<Block> HEVEA_LOG = registerBlock("hevea_log",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> HEVEA_WOOD = registerBlock("hevea_wood",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> STRIPPED_HEVEA_LOG = registerBlock("stripped_hevea_log",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> STRIPPED_HEVEA_WOOD = registerBlock("stripped_hevea_wood",
            ()->new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_WOOD)), ModCreativeModeTab.PANCRAFT_TAB);

    public static final RegistryObject<Block> HEVEA_PLANKS = registerBlock("hevea_planks",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.PANCRAFT_TAB);
    public static final RegistryObject<Block> HEVEA_LEAVES = registerBlock("hevea_leaves",
            ()->new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.PANCRAFT_TAB);

    public static final RegistryObject<Block> HEVEA_SAPLING = registerBlock("hevea_sapling",
            ()->new SaplingBlock(new HeveaTreeGrower()
                    ,BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.PANCRAFT_TAB);

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
