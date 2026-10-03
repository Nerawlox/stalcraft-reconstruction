/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundResultEvent;
import net.minecraftforge.event.ListenerList;

public class PlayStreamingEvent
extends SoundResultEvent {
    public final float x;
    public final float y;
    public final float z;
    private static ListenerList LISTENER_LIST;

    public PlayStreamingEvent(jzqf jzqf2, xavs xavs2, String string, float f, float f2, float f3) {
        super(jzqf2, xavs2, string, 0.0f, 0.0f);
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public PlayStreamingEvent() {
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

