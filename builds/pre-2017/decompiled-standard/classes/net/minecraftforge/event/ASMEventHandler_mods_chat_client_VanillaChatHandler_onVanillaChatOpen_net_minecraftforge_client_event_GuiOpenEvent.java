/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.chat.client.VanillaChatHandler;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_chat_client_VanillaChatHandler_onVanillaChatOpen_net_minecraftforge_client_event_GuiOpenEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_chat_client_VanillaChatHandler_onVanillaChatOpen_net_minecraftforge_client_event_GuiOpenEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((VanillaChatHandler)this.instance).onVanillaChatOpen((GuiOpenEvent)event);
    }
}

