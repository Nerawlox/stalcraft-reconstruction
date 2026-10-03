/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class ServerChatEvent
extends Event {
    public final String message;
    public final String username;
    public final EntityPlayerMP player;
    public ChatMessageComponent component;
    private static ListenerList LISTENER_LIST;

    public ServerChatEvent(EntityPlayerMP entityPlayerMP, String string, ChatMessageComponent chatMessageComponent) {
        this.message = string;
        this.player = entityPlayerMP;
        this.username = entityPlayerMP.username;
        this.component = chatMessageComponent;
    }

    public ServerChatEvent() {
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

