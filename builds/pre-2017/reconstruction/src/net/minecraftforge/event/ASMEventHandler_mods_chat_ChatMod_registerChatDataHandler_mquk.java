/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.chat.ChatMod;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_chat_ChatMod_registerChatDataHandler_mquk
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_chat_ChatMod_registerChatDataHandler_mquk(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ChatMod)this.instance).registerChatDataHandler((mquk)event);
    }
}

