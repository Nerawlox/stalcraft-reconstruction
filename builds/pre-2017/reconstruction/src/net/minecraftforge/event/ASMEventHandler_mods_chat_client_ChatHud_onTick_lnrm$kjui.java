/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import mods.chat.client.ChatHud;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.IEventListener;

public class ASMEventHandler_mods_chat_client_ChatHud_onTick_lnrm$kjui
implements IEventListener {
    public Object instance;

    public ASMEventHandler_mods_chat_client_ChatHud_onTick_lnrm$kjui(Object object) {
        this.instance = object;
    }

    @Override
    public void invoke(Event event) {
        ((ChatHud)this.instance).onTick((lnrm.kjui)event);
    }
}

