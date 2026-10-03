/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.brewing;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class PotionBrewedEvent
extends Event {
    public cvzo[] brewingStacks;
    private static ListenerList LISTENER_LIST;

    public PotionBrewedEvent(cvzo[] cvzoArray) {
        this.brewingStacks = cvzoArray;
    }

    public PotionBrewedEvent() {
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

