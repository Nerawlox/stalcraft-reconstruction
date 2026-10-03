/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.common.ForgeInternalHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ASMEventHandler_net_minecraftforge_common_ForgeInternalHandler_onEntityJoinWorld_net_minecraftforge_event_entity_EntityJoinWorldEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_net_minecraftforge_common_ForgeInternalHandler_onEntityJoinWorld_net_minecraftforge_event_entity_EntityJoinWorldEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ForgeInternalHandler)this.instance).onEntityJoinWorld((EntityJoinWorldEvent)event);
    }
}

