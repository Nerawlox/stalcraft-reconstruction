/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import noppes.npcs.events.PlayerEvent;

public class ASMEventHandler_noppes_npcs_events_PlayerEvent_playerHurt_net_minecraftforge_event_entity_living_LivingHurtEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_PlayerEvent_playerHurt_net_minecraftforge_event_entity_living_LivingHurtEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((PlayerEvent)this.instance).playerHurt((LivingHurtEvent)event);
    }
}

