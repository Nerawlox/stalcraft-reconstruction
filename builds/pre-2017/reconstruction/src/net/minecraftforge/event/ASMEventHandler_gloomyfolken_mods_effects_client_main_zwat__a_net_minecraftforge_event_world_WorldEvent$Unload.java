/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.effects.client.main.zwat;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.world.WorldEvent;

public class ASMEventHandler_gloomyfolken_mods_effects_client_main_zwat__a_net_minecraftforge_event_world_WorldEvent$Unload
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_effects_client_main_zwat__a_net_minecraftforge_event_world_WorldEvent$Unload(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((zwat)this.instance)._a((WorldEvent.Unload)event);
    }
}

