/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.pidb;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerSleepInBedEvent
extends PlayerEvent {
    public pidb result;
    public final int x;
    public final int y;
    public final int z;
    private static ListenerList LISTENER_LIST;

    public PlayerSleepInBedEvent(EntityPlayer entityPlayer, int n, int n2, int n3) {
        super(entityPlayer);
        this.result = null;
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public PlayerSleepInBedEvent() {
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

