/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.ListenerList;

public class SoundSetupEvent
extends SoundEvent {
    public final jzqf manager;
    private static ListenerList LISTENER_LIST;

    public SoundSetupEvent(jzqf jzqf2) {
        this.manager = jzqf2;
    }

    public SoundSetupEvent() {
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

