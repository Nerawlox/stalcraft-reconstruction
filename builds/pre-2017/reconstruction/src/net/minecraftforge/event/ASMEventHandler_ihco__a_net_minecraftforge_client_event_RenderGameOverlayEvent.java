/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_ihco__a_net_minecraftforge_client_event_RenderGameOverlayEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_ihco__a_net_minecraftforge_client_event_RenderGameOverlayEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ihco)this.instance)._a((RenderGameOverlayEvent)event);
    }
}

