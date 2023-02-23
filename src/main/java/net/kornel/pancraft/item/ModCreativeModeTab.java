package net.kornel.pancraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab PANCRAFT_TAB = new CreativeModeTab("pancraft") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SULFUR.get());
        }
    };
}
