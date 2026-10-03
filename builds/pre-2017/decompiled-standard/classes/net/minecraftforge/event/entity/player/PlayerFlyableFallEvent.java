/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerFlyableFallEvent
extends PlayerEvent {
    public float distance;
    private static ListenerList LISTENER_LIST;

    public PlayerFlyableFallEvent(EntityPlayer entityPlayer, float f) {
        super(entityPlayer);
        this.distance = f;
    }

    public PlayerFlyableFallEvent() {
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

