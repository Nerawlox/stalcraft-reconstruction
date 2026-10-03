/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class WorldTypeEvent
extends Event {
    public final nwix worldType;
    private static ListenerList LISTENER_LIST;

    public WorldTypeEvent(nwix nwix2) {
        this.worldType = nwix2;
    }

    public WorldTypeEvent() {
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

    public static class InitBiomeGens
    extends WorldTypeEvent {
        public final long seed;
        public final lqgz[] originalBiomeGens;
        public lqgz[] newBiomeGens;
        private static ListenerList LISTENER_LIST;

        public InitBiomeGens(nwix nwix2, long l, lqgz[] lqgzArray) {
            super(nwix2);
            this.seed = l;
            this.originalBiomeGens = lqgzArray;
            this.newBiomeGens = (lqgz[])lqgzArray.clone();
        }

        public InitBiomeGens() {
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

    public static class BiomeSize
    extends WorldTypeEvent {
        public final byte originalSize;
        public byte newSize;
        private static ListenerList LISTENER_LIST;

        public BiomeSize(nwix nwix2, byte by) {
            super(nwix2);
            this.originalSize = by;
            this.newSize = by;
        }

        public BiomeSize() {
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

