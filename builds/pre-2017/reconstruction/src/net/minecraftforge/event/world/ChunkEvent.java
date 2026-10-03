/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.world.WorldEvent;

public class ChunkEvent
extends WorldEvent {
    private final Chunk chunk;
    private static ListenerList LISTENER_LIST;

    public ChunkEvent(Chunk chunk) {
        super(chunk._g);
        this.chunk = chunk;
    }

    public Chunk getChunk() {
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

        public Unload(Chunk chunk) {
            super(chunk);
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

        public Load(Chunk chunk) {
            super(chunk);
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

