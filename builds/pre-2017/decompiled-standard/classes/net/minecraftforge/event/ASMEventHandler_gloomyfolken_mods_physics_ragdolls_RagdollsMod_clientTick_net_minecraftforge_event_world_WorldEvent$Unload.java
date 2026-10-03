/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.world.WorldEvent;

public class ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_clientTick_net_minecraftforge_event_world_WorldEvent$Unload
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_ragdolls_RagdollsMod_clientTick_net_minecraftforge_event_world_WorldEvent$Unload(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((RagdollsMod)this.instance).clientTick((WorldEvent.Unload)event);
    }
}

