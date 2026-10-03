/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.player.tupg;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class vjta {
    @ForgeSubscribe(priority=EventPriority.LOWEST)
    @ezey(_a={eidj.CLIENT})
    public void _a(RenderWorldLastEvent renderWorldLastEvent) {
        tupg._a();
    }
}

