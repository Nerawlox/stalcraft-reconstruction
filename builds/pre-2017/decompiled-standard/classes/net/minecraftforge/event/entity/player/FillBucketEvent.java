/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
@Event.HasResult
public class FillBucketEvent
extends PlayerEvent {
    public final cvzo current;
    public final ozlu world;
    public final hank target;
    public cvzo result;
    private static ListenerList LISTENER_LIST;

    public FillBucketEvent(EntityPlayer entityPlayer, cvzo cvzo2, ozlu ozlu2, hank hank2) {
        super(entityPlayer);
        this.current = cvzo2;
        this.world = ozlu2;
        this.target = hank2;
    }

    public FillBucketEvent() {
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

