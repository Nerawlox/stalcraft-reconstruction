/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.chat.client.ChatHud;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_chat_client_ChatHud_onChatRenderer_net_minecraftforge_client_event_RenderGameOverlayEvent
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_chat_client_ChatHud_onChatRenderer_net_minecraftforge_client_event_RenderGameOverlayEvent(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ChatHud)this.instance).onChatRenderer((RenderGameOverlayEvent)event);
    }
}

