/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.stalkerguide;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ForgeSubscribe;
import znw.mods.stalkerguide.pidb;

public class kjui {
    @ForgeSubscribe
    public void _a(gloomyfolken.mods.shop.pidb pidb2) {
        if (pidb2.entityPlayer instanceof EntityPlayerMP) {
            InvokeSideOnly.frontend(() -> {});
        } else {
            InvokeSideOnly.client(() -> {
                if (pidb._a()) {
                    pidb2.setCanceled(true);
                }
            });
        }
    }
}

