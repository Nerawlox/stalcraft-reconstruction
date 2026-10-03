/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

public class LivingSetAttackTargetEvent
extends LivingEvent {
    public final EntityLivingBase target;
    private static ListenerList LISTENER_LIST;

    public LivingSetAttackTargetEvent(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        super(entityLivingBase);
        this.target = entityLivingBase2;
    }

    public LivingSetAttackTargetEvent() {
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

