/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import gloomyfolken.mods.options.pidb;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_gloomyfolken_mods_options_pidb__a_net_minecraftforge_client_event_GuiOpenEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_gloomyfolken_mods_options_pidb__a_net_minecraftforge_client_event_GuiOpenEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((pidb)this.instance)._a((GuiOpenEvent)event);
    }
}

