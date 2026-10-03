/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.skinarmor;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class pidb {
    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(RenderPlayerEvent.Specials.Pre pre) {
        pre.renderCape = false;
    }
}

