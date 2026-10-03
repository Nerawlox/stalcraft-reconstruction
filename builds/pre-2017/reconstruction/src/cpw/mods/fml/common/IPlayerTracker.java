/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import net.minecraft.entity.player.EntityPlayer;

public interface IPlayerTracker {
    public void onPlayerLogin(EntityPlayer var1);

    public void onPlayerLogout(EntityPlayer var1);

    public void onPlayerChangedDimension(EntityPlayer var1);

    public void onPlayerRespawn(EntityPlayer var1);
}

