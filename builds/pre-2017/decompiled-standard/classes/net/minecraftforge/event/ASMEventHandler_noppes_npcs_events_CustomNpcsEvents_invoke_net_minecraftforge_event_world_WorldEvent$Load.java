/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.world.WorldEvent;
import noppes.npcs.events.CustomNpcsEvents;

public class ASMEventHandler_noppes_npcs_events_CustomNpcsEvents_invoke_net_minecraftforge_event_world_WorldEvent$Load
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_CustomNpcsEvents_invoke_net_minecraftforge_event_world_WorldEvent$Load(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((CustomNpcsEvents)this.instance).invoke((WorldEvent.Load)event);
    }
}

