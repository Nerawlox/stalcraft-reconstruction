/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class DecorateBiomeEvent
extends Event {
    public final ozlu world;
    public final Random rand;
    public final int chunkX;
    public final int chunkZ;
    private static ListenerList LISTENER_LIST;

    public DecorateBiomeEvent(ozlu ozlu2, Random random, int n, int n2) {
        this.world = ozlu2;
        this.rand = random;
        this.chunkX = n;
        this.chunkZ = n2;
    }

    public DecorateBiomeEvent() {
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
    public static class Decorate
    extends DecorateBiomeEvent {
        public final EventType type;
        private static ListenerList LISTENER_LIST;

        public Decorate(ozlu ozlu2, Random random, int n, int n2, EventType eventType) {
            super(ozlu2, random, n, n2);
            this.type = eventType;
        }

        public Decorate() {
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
            BIG_SHROOM,
            CACTUS,
            CLAY,
            DEAD_BUSH,
            LILYPAD,
            FLOWERS,
            GRASS,
            LAKE,
            PUMPKIN,
            REED,
            SAND,
            SAND_PASS2,
            SHROOM,
            TREE,
            CUSTOM;

        }
    }

    public static class Post
    extends DecorateBiomeEvent {
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
    extends DecorateBiomeEvent {
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

