/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ASMEventHandler_piuf__a_net_minecraftforge_event_entity_player_PlayerInteractEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_piuf__a_net_minecraftforge_event_entity_player_PlayerInteractEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((piuf)this.instance)._a((PlayerInteractEvent)event);
    }
}

