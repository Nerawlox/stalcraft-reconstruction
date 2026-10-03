/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLiving;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

public class LivingSpawnEvent
extends LivingEvent {
    public final ozlu world;
    public final float x;
    public final float y;
    public final float z;
    private static ListenerList LISTENER_LIST;

    public LivingSpawnEvent(EntityLiving entityLiving, ozlu ozlu2, float f, float f2, float f3) {
        super(entityLiving);
        this.world = ozlu2;
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public LivingSpawnEvent() {
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

    @Event.HasResult
    public static class AllowDespawn
    extends LivingSpawnEvent {
        private static ListenerList LISTENER_LIST;

        public AllowDespawn(EntityLiving entityLiving) {
            super(entityLiving, entityLiving.field_70170_p, (float)entityLiving.field_70165_t, (float)entityLiving.field_70163_u, (float)entityLiving.field_70161_v);
        }

        public AllowDespawn() {
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
    public static class SpecialSpawn
    extends LivingSpawnEvent {
        private static ListenerList LISTENER_LIST;

        public SpecialSpawn(EntityLiving entityLiving, ozlu ozlu2, float f, float f2, float f3) {
            super(entityLiving, ozlu2, f, f2, f3);
        }

        public SpecialSpawn() {
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

    @Event.HasResult
    public static class CheckSpawn
    extends LivingSpawnEvent {
        private static ListenerList LISTENER_LIST;

        public CheckSpawn(EntityLiving entityLiving, ozlu ozlu2, float f, float f2, float f3) {
            super(entityLiving, ozlu2, f, f2, f3);
        }

        public CheckSpawn() {
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

