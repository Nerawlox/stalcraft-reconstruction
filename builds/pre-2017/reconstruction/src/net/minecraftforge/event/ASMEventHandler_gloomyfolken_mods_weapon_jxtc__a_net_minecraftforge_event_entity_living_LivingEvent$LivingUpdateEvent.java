/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.weapon.jxtc;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.living.LivingEvent;

public class ASMEventHandler_gloomyfolken_mods_weapon_jxtc__a_net_minecraftforge_event_entity_living_LivingEvent$LivingUpdateEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_weapon_jxtc__a_net_minecraftforge_event_entity_living_LivingEvent$LivingUpdateEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jxtc)this.instance)._a((LivingEvent.LivingUpdateEvent)event);
    }
}

