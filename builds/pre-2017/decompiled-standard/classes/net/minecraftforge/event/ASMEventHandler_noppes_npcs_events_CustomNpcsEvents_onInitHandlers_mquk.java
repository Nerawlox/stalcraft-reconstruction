/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;
import noppes.npcs.events.CustomNpcsEvents;

public class ASMEventHandler_noppes_npcs_events_CustomNpcsEvents_onInitHandlers_mquk
implements IEventListener {
    public Object instance;

    public ASMEventHandler_noppes_npcs_events_CustomNpcsEvents_onInitHandlers_mquk(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((CustomNpcsEvents)this.instance).onInitHandlers((mquk)event);
    }
}

