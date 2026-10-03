/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class InitMapGenEvent
extends Event {
    public final EventType type;
    public final yfis originalGen;
    public yfis newGen;
    private static ListenerList LISTENER_LIST;

    InitMapGenEvent(EventType eventType, yfis yfis2) {
        this.type = eventType;
        this.originalGen = yfis2;
        this.newGen = yfis2;
    }

    public InitMapGenEvent() {
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

    public static enum EventType {
        CAVE,
        MINESHAFT,
        NETHER_BRIDGE,
        NETHER_CAVE,
        RAVINE,
        SCATTERED_FEATURE,
        STRONGHOLD,
        VILLAGE,
        CUSTOM;

    }
}

