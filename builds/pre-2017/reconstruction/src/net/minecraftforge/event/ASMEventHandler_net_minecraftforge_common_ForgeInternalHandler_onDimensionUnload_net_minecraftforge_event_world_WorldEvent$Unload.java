/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.common.ForgeInternalHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.world.WorldEvent;

public class ASMEventHandler_net_minecraftforge_common_ForgeInternalHandler_onDimensionUnload_net_minecraftforge_event_world_WorldEvent$Unload
implements IEventListener {
    public Object instance;

    public ASMEventHandler_net_minecraftforge_common_ForgeInternalHandler_onDimensionUnload_net_minecraftforge_event_world_WorldEvent$Unload(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ForgeInternalHandler)this.instance).onDimensionUnload((WorldEvent.Unload)event);
    }
}

