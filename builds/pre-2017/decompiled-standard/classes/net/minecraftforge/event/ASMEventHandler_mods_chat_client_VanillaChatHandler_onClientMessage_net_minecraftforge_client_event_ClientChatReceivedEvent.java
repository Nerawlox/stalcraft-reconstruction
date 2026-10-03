/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.chat.client.VanillaChatHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_chat_client_VanillaChatHandler_onClientMessage_net_minecraftforge_client_event_ClientChatReceivedEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_chat_client_VanillaChatHandler_onClientMessage_net_minecraftforge_client_event_ClientChatReceivedEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((VanillaChatHandler)this.instance).onClientMessage((ClientChatReceivedEvent)event);
    }
}

