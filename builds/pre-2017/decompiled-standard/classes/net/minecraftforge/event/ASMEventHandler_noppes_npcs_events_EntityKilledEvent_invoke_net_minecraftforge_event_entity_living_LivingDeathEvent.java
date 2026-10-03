/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import noppes.npcs.events.EntityKilledEvent;

public class ASMEventHandler_noppes_npcs_events_EntityKilledEvent_invoke_net_minecraftforge_event_entity_living_LivingDeathEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_EntityKilledEvent_invoke_net_minecraftforge_event_entity_living_LivingDeathEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((EntityKilledEvent)this.instance).invoke((LivingDeathEvent)event);
    }
}

