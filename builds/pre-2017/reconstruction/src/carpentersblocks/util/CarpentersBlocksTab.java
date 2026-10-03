/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util;

import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CarpentersBlocksTab
extends CreativeTabs {
    public CarpentersBlocksTab(String string) {
        super(string);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Item getTabIconItem() {
        return ItemHandler.itemCarpentersHammer;
    }

    @Override
    public String getTranslatedTabLabel() {
        return LanguageRegistry.instance().getStringLocalization("itemGroup.carpentersBlocks.name");
    }
}

