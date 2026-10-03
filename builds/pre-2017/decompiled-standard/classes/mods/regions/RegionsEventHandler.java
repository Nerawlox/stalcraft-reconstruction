/*
 * Decompiled with CFR 0.152.
 */
package mods.regions;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.shop.kjui;
import mods.regions.Region;
import mods.regions.RegionsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;

public class RegionsEventHandler {
    @ForgeSubscribe
    public void canOpenDonateInv(kjui kjui2) {
        EntityPlayer entityPlayer = kjui2.entityPlayer;
        Region region = entityPlayer.field_70170_p.field_72995_K ? InvokeWithResult.client(() -> RegionsMod.regionsClient.getCurrentRegion()) : InvokeWithResult.frontend(() -> null);
        kjui2.setCanceled(region == null || region.isPvp());
    }
}

