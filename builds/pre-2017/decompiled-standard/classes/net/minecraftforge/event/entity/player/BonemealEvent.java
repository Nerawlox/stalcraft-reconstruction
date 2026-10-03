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
public class BonemealEvent
extends PlayerEvent {
    public final ozlu world;
    public final int ID;
    public final int X;
    public final int Y;
    public final int Z;
    private static ListenerList LISTENER_LIST;

    public BonemealEvent(EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4) {
        super(entityPlayer);
        this.world = ozlu2;
        this.ID = n;
        this.X = n2;
        this.Y = n3;
        this.Z = n4;
    }

    public BonemealEvent() {
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

