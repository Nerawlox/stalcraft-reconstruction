/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.core.PhysicsMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.EntityEvent;

public class ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_attachPhysicsState_net_minecraftforge_event_entity_EntityEvent$EntityConstructing
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_attachPhysicsState_net_minecraftforge_event_entity_EntityEvent$EntityConstructing(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((PhysicsMod)this.instance).attachPhysicsState((EntityEvent.EntityConstructing)event);
    }
}

