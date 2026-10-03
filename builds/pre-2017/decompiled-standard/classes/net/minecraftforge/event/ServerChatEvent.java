/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwat;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class ServerChatEvent
extends Event {
    public final String message;
    public final String username;
    public final EntityPlayerMP player;
    public zwat component;
    private static ListenerList LISTENER_LIST;

    public ServerChatEvent(EntityPlayerMP entityPlayerMP, String string, zwat zwat2) {
        this.message = string;
        this.player = entityPlayerMP;
        this.username = entityPlayerMP.field_71092_bJ;
        this.component = zwat2;
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

