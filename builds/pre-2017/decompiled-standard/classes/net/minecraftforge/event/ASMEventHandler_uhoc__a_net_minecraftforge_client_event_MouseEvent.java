/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_uhoc__a_net_minecraftforge_client_event_MouseEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_uhoc__a_net_minecraftforge_client_event_MouseEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((uhoc)this.instance)._a((MouseEvent)event);
    }
}

