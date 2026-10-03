/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.minecart;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.minecart.MinecartEvent;

public class MinecartUpdateEvent
extends MinecartEvent {
    public final float x;
    public final float y;
    public final float z;
    private static ListenerList LISTENER_LIST;

    public MinecartUpdateEvent(EntityMinecart entityMinecart, float f, float f2, float f3) {
        super(entityMinecart);
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public MinecartUpdateEvent() {
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

