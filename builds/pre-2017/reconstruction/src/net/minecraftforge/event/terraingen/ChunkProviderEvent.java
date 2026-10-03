/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class ChunkProviderEvent
extends Event {
    public final IChunkProvider chunkProvider;
    private static ListenerList LISTENER_LIST;

    public ChunkProviderEvent(IChunkProvider iChunkProvider) {
        this.chunkProvider = iChunkProvider;
    }

    public ChunkProviderEvent() {
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
    public static class InitNoiseField
    extends ChunkProviderEvent {
        public double[] noisefield;
        public final int posX;
        public final int posY;
        public final int posZ;
        public final int sizeX;
        public final int sizeY;
        public final int sizeZ;
        private static ListenerList LISTENER_LIST;

        public InitNoiseField(IChunkProvider iChunkProvider, double[] dArray, int n, int n2, int n3, int n4, int n5, int n6) {
            super(iChunkProvider);
            this.noisefield = dArray;
            this.posX = n;
            this.posY = n2;
            this.posZ = n3;
            this.sizeX = n4;
            this.sizeY = n5;
            this.sizeZ = n6;
        }

        public InitNoiseField() {
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
    public static class ReplaceBiomeBlocks
    extends ChunkProviderEvent {
        public final int chunkX;
        public final int chunkZ;
        public final byte[] blockArray;
        public final BiomeGenBase[] biomeArray;
        private static ListenerList LISTENER_LIST;

        public ReplaceBiomeBlocks(IChunkProvider iChunkProvider, int n, int n2, byte[] byArray, BiomeGenBase[] biomeGenBaseArray) {
            super(iChunkProvider);
            this.chunkX = n;
            this.chunkZ = n2;
            this.blockArray = byArray;
            this.biomeArray = biomeGenBaseArray;
        }

        public ReplaceBiomeBlocks() {
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

