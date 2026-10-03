/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.mobs.StalkerMobsMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_stalker_mobs_StalkerMobsMod_handleMobPlayerKnockback_ntxh
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_mobs_StalkerMobsMod_handleMobPlayerKnockback_ntxh(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((StalkerMobsMod)this.instance).handleMobPlayerKnockback((ntxh)event);
    }
}

