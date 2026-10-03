/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.minecart;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.minecart.MinecartEvent;

@Cancelable
public class MinecartInteractEvent
extends MinecartEvent {
    public final EntityPlayer player;
    private static ListenerList LISTENER_LIST;

    public MinecartInteractEvent(EntityMinecart entityMinecart, EntityPlayer entityPlayer) {
        super(entityMinecart);
        this.player = entityPlayer;
    }

    public MinecartInteractEvent() {
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

