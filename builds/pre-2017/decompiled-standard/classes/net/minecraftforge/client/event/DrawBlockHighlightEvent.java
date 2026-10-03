/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class DrawBlockHighlightEvent
extends Event {
    public final cvgz context;
    public final EntityPlayer player;
    public final hank target;
    public final int subID;
    public final cvzo currentItem;
    public final float partialTicks;
    private static ListenerList LISTENER_LIST;

    public DrawBlockHighlightEvent(cvgz cvgz2, EntityPlayer entityPlayer, hank hank2, int n, cvzo cvzo2, float f) {
        this.context = cvgz2;
        this.player = entityPlayer;
        this.target = hank2;
        this.subID = n;
        this.currentItem = cvzo2;
        this.partialTicks = f;
    }

    public DrawBlockHighlightEvent() {
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

