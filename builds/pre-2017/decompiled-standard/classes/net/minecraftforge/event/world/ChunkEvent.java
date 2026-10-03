/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.world.WorldEvent;

public class ChunkEvent
extends WorldEvent {
    private final ixzi chunk;
    private static ListenerList LISTENER_LIST;

    public ChunkEvent(ixzi ixzi2) {
        super(ixzi2._g);
        this.chunk = ixzi2;
    }

    public ixzi getChunk() {
        return this.chunk;
    }

    public ChunkEvent() {
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

    public static class Unload
    extends ChunkEvent {
        private static ListenerList LISTENER_LIST;

        public Unload(ixzi ixzi2) {
            super(ixzi2);
        }

        public Unload() {
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
    extends ChunkEvent {
        private static ListenerList LISTENER_LIST;

        public Load(ixzi ixzi2) {
            super(ixzi2);
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

