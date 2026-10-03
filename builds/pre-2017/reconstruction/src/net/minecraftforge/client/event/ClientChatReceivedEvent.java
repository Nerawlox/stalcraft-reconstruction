/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class ClientChatReceivedEvent
extends Event {
    public String message;
    private static ListenerList LISTENER_LIST;

    public ClientChatReceivedEvent(String string) {
        this.message = string;
    }

    public ClientChatReceivedEvent() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (LISTENER_LIST != null) {
            return;
        }
        LISTENER_LIST = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return LISTENER_LIST;
    }
}

