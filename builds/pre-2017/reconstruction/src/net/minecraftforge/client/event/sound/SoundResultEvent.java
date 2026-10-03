/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.ListenerList;

public abstract class SoundResultEvent
extends SoundEvent {
    public final jzqf manager;
    public final xavs source;
    public final String name;
    public final float volume;
    public final float pitch;
    public xavs result;
    private static ListenerList LISTENER_LIST;

    public SoundResultEvent(jzqf jzqf2, xavs xavs2, String string, float f, float f2) {
        this.manager = jzqf2;
        this.source = xavs2;
        this.name = string;
        this.volume = f;
        this.pitch = f2;
        this.result = xavs2;
    }

    public SoundResultEvent() {
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

