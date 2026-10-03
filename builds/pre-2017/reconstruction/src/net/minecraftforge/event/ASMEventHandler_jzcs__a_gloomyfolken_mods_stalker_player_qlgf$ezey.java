/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.player.qlgf;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_jzcs__a_gloomyfolken_mods_stalker_player_qlgf$ezey
implements IEventListener {
    public Object instance;

    public ASMEventHandler_jzcs__a_gloomyfolken_mods_stalker_player_qlgf$ezey(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jzcs)this.instance)._a((qlgf.ezey)event);
    }
}

