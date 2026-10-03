/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
public class ArrowLooseEvent
extends PlayerEvent {
    public final cvzo bow;
    public int charge;
    private static ListenerList LISTENER_LIST;

    public ArrowLooseEvent(EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        super(entityPlayer);
        this.bow = cvzo2;
        this.charge = n;
    }

    public ArrowLooseEvent() {
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

