/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class ASMEventHandler_piuf__a_net_minecraftforge_event_entity_living_LivingHurtEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_piuf__a_net_minecraftforge_event_entity_living_LivingHurtEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((piuf)this.instance)._a((LivingHurtEvent)event);
    }
}

