/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerDestroyItemEvent
extends PlayerEvent {
    public final cvzo original;
    private static ListenerList LISTENER_LIST;

    public PlayerDestroyItemEvent(EntityPlayer entityPlayer, cvzo cvzo2) {
        super(entityPlayer);
        this.original = cvzo2;
    }

    public PlayerDestroyItemEvent() {
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

