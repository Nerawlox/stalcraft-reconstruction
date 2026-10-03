/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.permissions;

import net.minecraft.entity.player.EntityPlayer;

public interface PermissionsInterface {
    public boolean hasPermission(String var1, String var2);

    default public boolean hasPermission(EntityPlayer entityPlayer, String string) {
        return this.hasPermission(entityPlayer.username, string);
    }
}

