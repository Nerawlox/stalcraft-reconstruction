/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class OreGenEvent
extends Event {
    public final World world;
    public final Random rand;
    public final int worldX;
    public final int worldZ;
    private static ListenerList LISTENER_LIST;

    public OreGenEvent(World world, Random random, int n, int n2) {
        this.world = world;
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
        public final WorldGenerator generator;
        private static ListenerList LISTENER_LIST;

        public GenerateMinable(World world, Random random, WorldGenerator worldGenerator, int n, int n2, EventType eventType) {
            super(world, random, n, n2);
            this.generator = worldGenerator;
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

        public Post(World world, Random random, int n, int n2) {
            super(world, random, n, n2);
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

        public Pre(World world, Random random, int n, int n2) {
            super(world, random, n, n2);
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

