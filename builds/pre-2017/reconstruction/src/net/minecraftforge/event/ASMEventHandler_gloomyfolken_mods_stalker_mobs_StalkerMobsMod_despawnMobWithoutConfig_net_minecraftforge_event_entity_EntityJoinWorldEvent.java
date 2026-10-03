/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.stalker.mobs.StalkerMobsMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ASMEventHandler_gloomyfolken_mods_stalker_mobs_StalkerMobsMod_despawnMobWithoutConfig_net_minecraftforge_event_entity_EntityJoinWorldEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_stalker_mobs_StalkerMobsMod_despawnMobWithoutConfig_net_minecraftforge_event_entity_EntityJoinWorldEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((StalkerMobsMod)this.instance).despawnMobWithoutConfig((EntityJoinWorldEvent)event);
    }
}

