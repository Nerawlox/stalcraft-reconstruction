/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.core.main.CommonEventHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_core_main_CommonEventHandler_onStatsTooltip_ycvh
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_core_main_CommonEventHandler_onStatsTooltip_ycvh(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((CommonEventHandler)this.instance).onStatsTooltip((ycvh)event);
    }
}

