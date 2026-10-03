/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import net.minecraft.entity.player.EntityPlayer;

public interface ezfc {
    default public boolean hasEditPermissions(EntityPlayer entityPlayer) {
        return entityPlayer.field_71075_bZ._d;
    }
}

