/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class RenderWorldLastEvent
extends Event {
    public final cvgz context;
    public final float partialTicks;
    private static ListenerList LISTENER_LIST;

    public RenderWorldLastEvent(cvgz cvgz2, float f) {
        this.context = cvgz2;
        this.partialTicks = f;
    }

    public RenderWorldLastEvent() {
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

