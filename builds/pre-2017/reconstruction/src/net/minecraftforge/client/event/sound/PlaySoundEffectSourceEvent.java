/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.ListenerList;

public class PlaySoundEffectSourceEvent
extends SoundEvent {
    public final jzqf manager;
    public final String name;
    private static ListenerList LISTENER_LIST;

    public PlaySoundEffectSourceEvent(jzqf jzqf2, String string) {
        this.manager = jzqf2;
        this.name = string;
    }

    public PlaySoundEffectSourceEvent() {
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

