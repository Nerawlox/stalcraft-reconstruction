/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundResultEvent;
import net.minecraftforge.event.ListenerList;

public class PlaySoundEffectEvent
extends SoundResultEvent {
    private static ListenerList LISTENER_LIST;

    public PlaySoundEffectEvent(jzqf jzqf2, xavs xavs2, String string, float f, float f2) {
        super(jzqf2, xavs2, string, f, f2);
    }

    public PlaySoundEffectEvent() {
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

