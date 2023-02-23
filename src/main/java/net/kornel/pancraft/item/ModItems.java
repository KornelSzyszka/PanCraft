package net.kornel.pancraft.item;

import net.kornel.pancraft.PanCraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PanCraft.MOD_ID);

    public static final RegistryObject<Item> NITER = ITEMS.register("niter",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PANCRAFT_TAB)));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PANCRAFT_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
