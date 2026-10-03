/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.ListenerList;

public class PlaySoundSourceEvent
extends SoundEvent {
    public final jzqf manager;
    public final String name;
    public final float x;
    public final float y;
    public final float z;
    private static ListenerList LISTENER_LIST;

    public PlaySoundSourceEvent(jzqf jzqf2, String string, float f, float f2, float f3) {
        this.manager = jzqf2;
        this.name = string;
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public PlaySoundSourceEvent() {
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

