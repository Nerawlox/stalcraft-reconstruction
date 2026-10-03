/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class CommandEvent
extends Event {
    public final kmew command;
    public final nemo sender;
    public String[] parameters;
    public Throwable exception;
    private static ListenerList LISTENER_LIST;

    public CommandEvent(kmew kmew2, nemo nemo2, String[] stringArray) {
        this.command = kmew2;
        this.sender = nemo2;
        this.parameters = stringArray;
    }

    public CommandEvent() {
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

