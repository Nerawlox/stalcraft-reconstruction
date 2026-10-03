/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.pda.client.ClientHandler;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_pda_client_ClientHandler_onClientDeath_net_minecraftforge_client_event_GuiOpenEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_pda_client_ClientHandler_onClientDeath_net_minecraftforge_client_event_GuiOpenEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ClientHandler)this.instance).onClientDeath((GuiOpenEvent)event);
    }
}

