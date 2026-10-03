/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

@Cancelable
public class EnderTeleportEvent
extends LivingEvent {
    public double targetX;
    public double targetY;
    public double targetZ;
    public float attackDamage;
    private static ListenerList LISTENER_LIST;

    public EnderTeleportEvent(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f) {
        super(entityLivingBase);
        this.targetX = d;
        this.targetY = d2;
        this.targetZ = d3;
        this.attackDamage = f;
    }

    public EnderTeleportEvent() {
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

