/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.core.PhysicsMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_entityJoinedWorld_net_minecraftforge_event_entity_EntityJoinWorldEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_entityJoinedWorld_net_minecraftforge_event_entity_EntityJoinWorldEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((PhysicsMod)this.instance).entityJoinedWorld((EntityJoinWorldEvent)event);
    }
}

