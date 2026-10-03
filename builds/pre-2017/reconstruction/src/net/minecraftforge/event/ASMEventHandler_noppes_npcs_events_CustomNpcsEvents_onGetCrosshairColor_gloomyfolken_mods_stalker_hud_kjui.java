/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.hud.kjui;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import noppes.npcs.events.CustomNpcsEvents;

public class ASMEventHandler_noppes_npcs_events_CustomNpcsEvents_onGetCrosshairColor_gloomyfolken_mods_stalker_hud_kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_CustomNpcsEvents_onGetCrosshairColor_gloomyfolken_mods_stalker_hud_kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((CustomNpcsEvents)this.instance).onGetCrosshairColor((kjui)event);
    }
}

