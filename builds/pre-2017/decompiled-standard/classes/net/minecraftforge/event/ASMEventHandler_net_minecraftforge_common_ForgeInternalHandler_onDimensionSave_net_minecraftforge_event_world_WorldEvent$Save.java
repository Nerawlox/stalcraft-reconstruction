/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.common.ForgeInternalHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.world.WorldEvent;

public class ASMEventHandler_net_minecraftforge_common_ForgeInternalHandler_onDimensionSave_net_minecraftforge_event_world_WorldEvent$Save
implements IEventListener {
    public Object instance;

    public ASMEventHandler_net_minecraftforge_common_ForgeInternalHandler_onDimensionSave_net_minecraftforge_event_world_WorldEvent$Save(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ForgeInternalHandler)this.instance).onDimensionSave((WorldEvent.Save)event);
    }
}

