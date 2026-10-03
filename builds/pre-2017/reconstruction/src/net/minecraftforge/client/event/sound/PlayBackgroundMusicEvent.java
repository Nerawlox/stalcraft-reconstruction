/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundResultEvent;
import net.minecraftforge.event.ListenerList;

public class PlayBackgroundMusicEvent
extends SoundResultEvent {
    private static ListenerList LISTENER_LIST;

    public PlayBackgroundMusicEvent(jzqf jzqf2, xavs xavs2) {
        super(jzqf2, xavs2, null, 0.0f, 0.0f);
    }

    public PlayBackgroundMusicEvent() {
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

