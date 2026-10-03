/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

public class LivingEvent
extends EntityEvent {
    public final EntityLivingBase entityLiving;
    private static ListenerList LISTENER_LIST;

    public LivingEvent(EntityLivingBase entityLivingBase) {
        super(entityLivingBase);
        this.entityLiving = entityLivingBase;
    }

    public LivingEvent() {
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

    public static class LivingJumpEvent
    extends LivingEvent {
        private static ListenerList LISTENER_LIST;

        public LivingJumpEvent(EntityLivingBase entityLivingBase) {
            super(entityLivingBase);
        }

        public LivingJumpEvent() {
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

    @Cancelable
    public static class LivingUpdateEvent
    extends LivingEvent {
        private static ListenerList LISTENER_LIST;

        public LivingUpdateEvent(EntityLivingBase entityLivingBase) {
            super(entityLivingBase);
        }

        public LivingUpdateEvent() {
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
}

