/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
@Event.HasResult
public class UseHoeEvent
extends PlayerEvent {
    public final cvzo current;
    public final ozlu world;
    public final int x;
    public final int y;
    public final int z;
    private boolean handeled;
    private static ListenerList LISTENER_LIST;

    public UseHoeEvent(EntityPlayer entityPlayer, cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3) {
        super(entityPlayer);
        this.handeled = false;
        this.current = cvzo2;
        this.world = ozlu2;
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public UseHoeEvent() {
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

