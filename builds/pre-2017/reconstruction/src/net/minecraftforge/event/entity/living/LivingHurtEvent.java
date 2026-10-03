/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

@Cancelable
public class LivingHurtEvent
extends LivingEvent {
    public final DamageSource source;
    public float ammount;
    private static ListenerList LISTENER_LIST;

    public LivingHurtEvent(EntityLivingBase entityLivingBase, DamageSource damageSource, float f) {
        super(entityLivingBase);
        this.source = damageSource;
        this.ammount = f;
    }

    public LivingHurtEvent() {
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

