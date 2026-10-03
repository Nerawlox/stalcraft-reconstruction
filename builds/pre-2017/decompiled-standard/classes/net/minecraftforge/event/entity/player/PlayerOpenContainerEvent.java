/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Event.HasResult
public class PlayerOpenContainerEvent
extends PlayerEvent {
    public final boolean canInteractWith;
    private static ListenerList LISTENER_LIST;

    public PlayerOpenContainerEvent(EntityPlayer entityPlayer, jjgc jjgc2) {
        super(entityPlayer);
        this.canInteractWith = jjgc2.func_75145_c(entityPlayer);
    }

    public PlayerOpenContainerEvent() {
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

