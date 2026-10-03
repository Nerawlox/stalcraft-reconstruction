/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLiving;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

@Event.HasResult
public class LivingPackSizeEvent
extends LivingEvent {
    public int maxPackSize;
    private static ListenerList LISTENER_LIST;

    public LivingPackSizeEvent(EntityLiving entityLiving) {
        super(entityLiving);
    }

    public LivingPackSizeEvent() {
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

