/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.core.PhysicsMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_tick_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_tick_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((PhysicsMod)this.instance).tick((lnrm.kjui)event);
    }
}

