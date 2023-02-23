package net.kornel.pancraft.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.kornel.pancraft.PanCraft;
import net.kornel.pancraft.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, PanCraft.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SULFUR_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SULFUR_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SULFUR_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?,?>> SULFUR_ORE = CONFIGURED_FEATURES.register("sulfur_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SULFUR_ORES.get(), 12)));


    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_NITER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.NITER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_NITER_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?,?>> NITER_ORE = CONFIGURED_FEATURES.register("niter_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_NITER_ORES.get(), 12)));

    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
