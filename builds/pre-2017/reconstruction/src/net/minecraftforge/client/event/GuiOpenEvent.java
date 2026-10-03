/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class GuiOpenEvent
extends Event {
    public GuiScreen gui;
    private static ListenerList LISTENER_LIST;

    public GuiOpenEvent(GuiScreen guiScreen) {
        this.gui = guiScreen;
    }

    public GuiOpenEvent() {
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

