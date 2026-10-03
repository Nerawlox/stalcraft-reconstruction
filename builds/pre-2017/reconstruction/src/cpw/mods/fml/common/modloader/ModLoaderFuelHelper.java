/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.modloader.BaseModProxy;
import net.minecraft.item.ItemStack;

public class ModLoaderFuelHelper
implements IFuelHandler {
    private BaseModProxy mod;

    public ModLoaderFuelHelper(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.mod.addFuel(itemStack._d, itemStack._j());
    }
}

