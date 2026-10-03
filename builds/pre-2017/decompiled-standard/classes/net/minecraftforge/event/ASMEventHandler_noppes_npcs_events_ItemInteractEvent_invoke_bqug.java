/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import noppes.npcs.events.ItemInteractEvent;

public class ASMEventHandler_noppes_npcs_events_ItemInteractEvent_invoke_bqug
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_ItemInteractEvent_invoke_bqug(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ItemInteractEvent)this.instance).invoke((bqug)event);
    }
}

