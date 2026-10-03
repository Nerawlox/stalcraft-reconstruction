/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.jxtc;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

@Cancelable
public class LivingDeathEvent
extends LivingEvent {
    public final jxtc source;
    private static ListenerList LISTENER_LIST;

    public LivingDeathEvent(EntityLivingBase entityLivingBase, jxtc jxtc2) {
        super(entityLivingBase);
        this.source = jxtc2;
    }

    public LivingDeathEvent() {
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

