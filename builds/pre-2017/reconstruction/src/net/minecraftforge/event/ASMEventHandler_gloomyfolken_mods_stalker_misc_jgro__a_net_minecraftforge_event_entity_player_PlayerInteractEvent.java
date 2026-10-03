/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.misc.jgro;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ASMEventHandler_gloomyfolken_mods_stalker_misc_jgro__a_net_minecraftforge_event_entity_player_PlayerInteractEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_misc_jgro__a_net_minecraftforge_event_entity_player_PlayerInteractEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jgro)this.instance)._a((PlayerInteractEvent)event);
    }
}

