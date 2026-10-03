/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.IPickupNotifier;
import cpw.mods.fml.common.modloader.BaseModProxy;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

public class ModLoaderPickupNotifier
implements IPickupNotifier {
    private BaseModProxy mod;

    public ModLoaderPickupNotifier(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void notifyPickup(EntityItem entityItem, EntityPlayer entityPlayer) {
        this.mod.onItemPickup(entityPlayer, entityItem.func_92059_d());
    }
}

