/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

@Cancelable
public class EntityStruckByLightningEvent
extends EntityEvent {
    public final EntityLightningBolt lightning;
    private static ListenerList LISTENER_LIST;

    public EntityStruckByLightningEvent(Entity entity, EntityLightningBolt entityLightningBolt) {
        super(entity);
        this.lightning = entityLightningBolt;
    }

    public EntityStruckByLightningEvent() {
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

