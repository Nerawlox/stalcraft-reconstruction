/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import noppes.npcs.events.ItemInteractEvent;

public class ASMEventHandler_noppes_npcs_events_ItemInteractEvent_invoke2_net_minecraftforge_event_entity_player_EntityInteractEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_ItemInteractEvent_invoke2_net_minecraftforge_event_entity_player_EntityInteractEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ItemInteractEvent)this.instance).invoke2((EntityInteractEvent)event);
    }
}

