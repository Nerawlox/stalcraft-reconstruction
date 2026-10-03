/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.clans.ezey;
import gloomyfolken.mods.stalker.player.qlgf;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_stalker_clans_ezey__a_gloomyfolken_mods_stalker_player_qlgf$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_clans_ezey__a_gloomyfolken_mods_stalker_player_qlgf$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ezey)this.instance)._a((qlgf.kjui)event);
    }
}

