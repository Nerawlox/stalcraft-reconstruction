/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import org.lwjgl.input.Mouse;

@Cancelable
public class MouseEvent
extends Event {
    public final int x = Mouse.getEventX();
    public final int y = Mouse.getEventY();
    public final int dx = Mouse.getEventDX();
    public final int dy = Mouse.getEventDY();
    public final int dwheel = Mouse.getEventDWheel();
    public final int button = Mouse.getEventButton();
    public final boolean buttonstate = Mouse.getEventButtonState();
    public final long nanoseconds = Mouse.getEventNanoseconds();
    private static ListenerList LISTENER_LIST;

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

