/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event.sound;

import net.minecraftforge.client.event.sound.SoundResultEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class SoundEvent
extends Event {
    private static ListenerList LISTENER_LIST;

    public static xavs getResult(SoundResultEvent soundResultEvent) {
        MinecraftForge.EVENT_BUS.post(soundResultEvent);
        return soundResultEvent.result;
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

