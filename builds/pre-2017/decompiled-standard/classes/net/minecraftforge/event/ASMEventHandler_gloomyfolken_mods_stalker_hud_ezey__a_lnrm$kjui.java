/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.hud.ezey;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_stalker_hud_ezey__a_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_hud_ezey__a_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ezey)this.instance)._a((lnrm.kjui)event);
    }
}

