/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.clans.ezey;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_stalker_clans_ezey__a_ycvh
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_clans_ezey__a_ycvh(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ezey)this.instance)._a((ycvh)event);
    }
}

