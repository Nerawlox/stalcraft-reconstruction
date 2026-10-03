/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.world.ChunkEvent;

public class ChunkDataEvent
extends ChunkEvent {
    private final qoac data;
    private static ListenerList LISTENER_LIST;

    public ChunkDataEvent(ixzi ixzi2, qoac qoac2) {
        super(ixzi2);
        this.data = qoac2;
    }

    public qoac getData() {
        return this.data;
    }

    public ChunkDataEvent() {
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

    public static class Save
    extends ChunkDataEvent {
        private static ListenerList LISTENER_LIST;

        public Save(ixzi ixzi2, qoac qoac2) {
            super(ixzi2, qoac2);
        }

        public Save() {
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

    public static class Load
    extends ChunkDataEvent {
        private static ListenerList LISTENER_LIST;

        public Load(ixzi ixzi2, qoac qoac2) {
            super(ixzi2, qoac2);
        }

        public Load() {
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

