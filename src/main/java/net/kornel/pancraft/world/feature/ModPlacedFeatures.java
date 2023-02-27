package net.kornel.pancraft.world.feature;

import net.kornel.pancraft.PanCraft;
import net.kornel.pancraft.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PanCraft.MOD_ID);

    public static final RegistryObject<PlacedFeature> SULFUR_ORE_PLACED = PLACED_FEATURES.register("sulfur_ore_placed",
            ()-> new PlacedFeature(ModConfiguredFeatures.SULFUR_ORE.getHolder().get(),
                    commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(100)))));

    public static final RegistryObject<PlacedFeature> NETHER_SULFUR_ORE_PLACED = PLACED_FEATURES.register("nether_sulfur_ore_placed",
            ()-> new PlacedFeature(ModConfiguredFeatures.NETHER_SULFUR_ORE.getHolder().get(),
                    commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(100)))));


    public static final RegistryObject<PlacedFeature> NITER_ORE_PLACED = PLACED_FEATURES.register("niter_ore_placed",
            ()-> new PlacedFeature(ModConfiguredFeatures.NITER_ORE.getHolder().get(),
                    commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(100)))));

    public static final RegistryObject<PlacedFeature> HEVEA_CHECKED = PLACED_FEATURES.register("hevea_checked",
            ()-> new PlacedFeature(ModConfiguredFeatures.HEVEA.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.HEVEA_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> HEVEA_PLACED = PLACED_FEATURES.register("hevea_placed",
            ()-> new PlacedFeature(ModConfiguredFeatures.HEVEA_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3,0.1f,2))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
