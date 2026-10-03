/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_yuet__a_net_minecraftforge_client_event_MouseEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_yuet__a_net_minecraftforge_client_event_MouseEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((yuet)this.instance)._a((MouseEvent)event);
    }
}

