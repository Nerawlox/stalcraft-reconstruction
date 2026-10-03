/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.weapon.jxtc;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class ASMEventHandler_gloomyfolken_mods_weapon_jxtc__b_net_minecraftforge_event_entity_living_LivingDeathEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_weapon_jxtc__b_net_minecraftforge_event_entity_living_LivingDeathEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((jxtc)this.instance)._b((LivingDeathEvent)event);
    }
}

