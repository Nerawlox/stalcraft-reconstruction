/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.modloader.BaseModProxy;
import net.minecraft.entity.player.EntityPlayer;

public class ModLoaderCraftingHelper
implements ICraftingHandler {
    private BaseModProxy mod;

    public ModLoaderCraftingHelper(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void onCrafting(EntityPlayer entityPlayer, cvzo cvzo2, mssh mssh2) {
        this.mod.takenFromCrafting(entityPlayer, cvzo2, mssh2);
    }

    @Override
    public void onSmelting(EntityPlayer entityPlayer, cvzo cvzo2) {
        this.mod.takenFromFurnace(entityPlayer, cvzo2);
    }
}

