/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util;

import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CarpentersBlocksTab
extends tgbl {
    public CarpentersBlocksTab(String string) {
        super(string);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public tgdv func_78016_d() {
        return ItemHandler.itemCarpentersHammer;
    }

    @Override
    public String func_78024_c() {
        return LanguageRegistry.instance().getStringLocalization("itemGroup.carpentersBlocks.name");
    }
}

