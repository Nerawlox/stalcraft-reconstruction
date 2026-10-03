/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.physics.core.PhysicsMod;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_renderBulletWorlds_net_minecraftforge_client_event_RenderWorldLastEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_physics_core_PhysicsMod_renderBulletWorlds_net_minecraftforge_client_event_RenderWorldLastEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((PhysicsMod)this.instance).renderBulletWorlds((RenderWorldLastEvent)event);
    }
}

