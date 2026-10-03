/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;

public class PopulateChunkEvent
extends ChunkProviderEvent {
    public final ozlu world;
    public final Random rand;
    public final int chunkX;
    public final int chunkZ;
    public final boolean hasVillageGenerated;
    private static ListenerList LISTENER_LIST;

    public PopulateChunkEvent(mccn mccn2, ozlu ozlu2, Random random, int n, int n2, boolean bl) {
        super(mccn2);
        this.world = ozlu2;
        this.rand = random;
        this.chunkX = n;
        this.chunkZ = n2;
        this.hasVillageGenerated = bl;
    }

    public PopulateChunkEvent() {
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
    public static class Populate
    extends PopulateChunkEvent {
        public final EventType type;
        private static ListenerList LISTENER_LIST;

        public Populate(mccn mccn2, ozlu ozlu2, Random random, int n, int n2, boolean bl, EventType eventType) {
            super(mccn2, ozlu2, random, n, n2, bl);
            this.type = eventType;
        }

        public Populate() {
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

        public static enum EventType {
            DUNGEON,
            FIRE,
            GLOWSTONE,
            ICE,
            LAKE,
            LAVA,
            NETHER_LAVA,
            CUSTOM;

        }
    }

    public static class Post
    extends PopulateChunkEvent {
        private static ListenerList LISTENER_LIST;

        public Post(mccn mccn2, ozlu ozlu2, Random random, int n, int n2, boolean bl) {
            super(mccn2, ozlu2, random, n, n2, bl);
        }

        public Post() {
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

    public static class Pre
    extends PopulateChunkEvent {
        private static ListenerList LISTENER_LIST;

        public Pre(mccn mccn2, ozlu ozlu2, Random random, int n, int n2, boolean bl) {
            super(mccn2, ozlu2, random, n, n2, bl);
        }

        public Pre() {
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

