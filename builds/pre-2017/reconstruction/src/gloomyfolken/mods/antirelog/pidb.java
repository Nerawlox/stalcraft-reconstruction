/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.antirelog;

import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.antirelog.eidj;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.stalker.player.qlgf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class pidb {
    @ForgeSubscribe(priority=EventPriority.LOWEST)
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(qlgf.pidb pidb2) {
        if (!pidb2.isCanceled() && eidj._a((EntityPlayer)pidb2._a)._b._b().booleanValue()) {
            ezfc._a();
            ezfc._a(0.0f, -0.6f, 0.0f);
        }
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void _a(qlgf.kjui kjui2) {
        if (eidj._a((EntityPlayer)kjui2._a)._b._b().booleanValue()) {
            ezfc._b();
        }
    }
}

