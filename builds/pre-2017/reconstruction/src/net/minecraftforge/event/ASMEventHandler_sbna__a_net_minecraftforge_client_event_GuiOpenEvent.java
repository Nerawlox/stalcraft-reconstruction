/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_sbna__a_net_minecraftforge_client_event_GuiOpenEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_sbna__a_net_minecraftforge_client_event_GuiOpenEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((sbna)this.instance)._a((GuiOpenEvent)event);
    }
}

