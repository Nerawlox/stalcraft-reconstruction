/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.minecart;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.minecart.MinecartEvent;

public class MinecartCollisionEvent
extends MinecartEvent {
    public final Entity collider;
    private static ListenerList LISTENER_LIST;

    public MinecartCollisionEvent(EntityMinecart entityMinecart, Entity entity) {
        super(entityMinecart);
        this.collider = entity;
    }

    public MinecartCollisionEvent() {
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

