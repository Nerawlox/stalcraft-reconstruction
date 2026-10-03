/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.minecart;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

public class MinecartEvent
extends EntityEvent {
    public final EntityMinecart minecart;
    private static ListenerList LISTENER_LIST;

    public MinecartEvent(EntityMinecart entityMinecart) {
        super(entityMinecart);
        this.minecart = entityMinecart;
    }

    public MinecartEvent() {
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

