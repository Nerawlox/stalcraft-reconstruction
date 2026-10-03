/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class FOVUpdateEvent
extends Event {
    public final EntityPlayerSP entity;
    public final float fov;
    public float newfov;
    private static ListenerList LISTENER_LIST;

    public FOVUpdateEvent(EntityPlayerSP entityPlayerSP, float f) {
        this.entity = entityPlayerSP;
        this.fov = f;
        this.newfov = f;
    }

    public FOVUpdateEvent() {
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

