/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.map;

import mods.pda.client.minimap.MapCanvas;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class MapInitEvent
extends Event {
    public final MapCanvas canvas;
    private static ListenerList LISTENER_LIST;

    public MapInitEvent(MapCanvas mapCanvas) {
        this.canvas = mapCanvas;
    }

    public MapInitEvent() {
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

