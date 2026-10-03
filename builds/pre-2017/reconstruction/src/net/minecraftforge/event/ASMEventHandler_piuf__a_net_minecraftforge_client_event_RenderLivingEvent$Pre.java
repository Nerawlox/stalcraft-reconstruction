/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_piuf__a_net_minecraftforge_client_event_RenderLivingEvent$Pre
implements IEventListener {
    public Object instance;

    public ASMEventHandler_piuf__a_net_minecraftforge_client_event_RenderLivingEvent$Pre(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((piuf)this.instance)._a((RenderLivingEvent.Pre)event);
    }
}

