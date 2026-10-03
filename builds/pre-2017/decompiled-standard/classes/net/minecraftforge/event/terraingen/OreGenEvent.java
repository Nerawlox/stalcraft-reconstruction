/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class OreGenEvent
extends Event {
    public final ozlu world;
    public final Random rand;
    public final int worldX;
    public final int worldZ;
    private static ListenerList LISTENER_LIST;

    public OreGenEvent(ozlu ozlu2, Random random, int n, int n2) {
        this.world = ozlu2;
        this.rand = random;
        this.worldX = n;
        this.worldZ = n2;
    }

    public OreGenEvent() {
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
    public static class GenerateMinable
    extends OreGenEvent {
        public final EventType type;
        public final zzpm generator;
        private static ListenerList LISTENER_LIST;

        public GenerateMinable(ozlu ozlu2, Random random, zzpm zzpm2, int n, int n2, EventType eventType) {
            super(ozlu2, random, n, n2);
            this.generator = zzpm2;
            this.type = eventType;
        }

        public GenerateMinable() {
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
            COAL,
            DIAMOND,
            DIRT,
            GOLD,
            GRAVEL,
            IRON,
            LAPIS,
            REDSTONE,
            CUSTOM;

        }
    }

    public static class Post
    extends OreGenEvent {
        private static ListenerList LISTENER_LIST;

        public Post(ozlu ozlu2, Random random, int n, int n2) {
            super(ozlu2, random, n, n2);
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
    extends OreGenEvent {
        private static ListenerList LISTENER_LIST;

        public Pre(ozlu ozlu2, Random random, int n, int n2) {
            super(ozlu2, random, n, n2);
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

