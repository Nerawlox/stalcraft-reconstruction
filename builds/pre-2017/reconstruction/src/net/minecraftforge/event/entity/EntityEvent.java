/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class EntityEvent
extends Event {
    public final Entity entity;
    private static ListenerList LISTENER_LIST;

    public EntityEvent(Entity entity) {
        this.entity = entity;
    }

    public EntityEvent() {
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

    public static class EnteringChunk
    extends EntityEvent {
        public int newChunkX;
        public int newChunkZ;
        public int oldChunkX;
        public int oldChunkZ;
        private static ListenerList LISTENER_LIST;

        public EnteringChunk(Entity entity, int n, int n2, int n3, int n4) {
            super(entity);
            this.newChunkX = n;
            this.newChunkZ = n2;
            this.oldChunkX = n3;
            this.oldChunkZ = n4;
        }

        public EnteringChunk() {
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

    public static class CanUpdate
    extends EntityEvent {
        public boolean canUpdate;
        private static ListenerList LISTENER_LIST;

        public CanUpdate(Entity entity) {
            super(entity);
            this.canUpdate = false;
        }

        public CanUpdate() {
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

    public static class EntityConstructing
    extends EntityEvent {
        private static ListenerList LISTENER_LIST;

        public EntityConstructing(Entity entity) {
            super(entity);
        }

        public EntityConstructing() {
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

