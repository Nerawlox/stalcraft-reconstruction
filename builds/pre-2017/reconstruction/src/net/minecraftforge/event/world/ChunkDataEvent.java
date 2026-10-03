/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.world.ChunkEvent;

public class ChunkDataEvent
extends ChunkEvent {
    private final NBTTagCompound data;
    private static ListenerList LISTENER_LIST;

    public ChunkDataEvent(Chunk chunk, NBTTagCompound nBTTagCompound) {
        super(chunk);
        this.data = nBTTagCompound;
    }

    public NBTTagCompound getData() {
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

        public Save(Chunk chunk, NBTTagCompound nBTTagCompound) {
            super(chunk, nBTTagCompound);
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

        public Load(Chunk chunk, NBTTagCompound nBTTagCompound) {
            super(chunk, nBTTagCompound);
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

