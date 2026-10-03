/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class DrawBlockHighlightEvent
extends Event {
    public final cvgz context;
    public final EntityPlayer player;
    public final MovingObjectPosition target;
    public final int subID;
    public final ItemStack currentItem;
    public final float partialTicks;
    private static ListenerList LISTENER_LIST;

    public DrawBlockHighlightEvent(cvgz cvgz2, EntityPlayer entityPlayer, MovingObjectPosition movingObjectPosition, int n, ItemStack itemStack, float f) {
        this.context = cvgz2;
        this.player = entityPlayer;
        this.target = movingObjectPosition;
        this.subID = n;
        this.currentItem = itemStack;
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

