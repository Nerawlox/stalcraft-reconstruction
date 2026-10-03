/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class WorldEvent
extends Event {
    public final World world;
    private static ListenerList LISTENER_LIST;

    public WorldEvent(World world) {
        this.world = world;
    }

    public WorldEvent() {
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

    @Cancelable
    public static class PotentialSpawns
    extends WorldEvent {
        public final EnumCreatureType type;
        public final int x;
        public final int y;
        public final int z;
        public final List<yffo> list;
        private static ListenerList LISTENER_LIST;

        public PotentialSpawns(World world, EnumCreatureType enumCreatureType, int n, int n2, int n3, List list2) {
            super(world);
            this.x = n;
            this.y = n2;
            this.z = n3;
            this.type = enumCreatureType;
            this.list = list2 != null ? list2 : new ArrayList<yffo>();
        }

        public PotentialSpawns() {
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

    public static class Save
    extends WorldEvent {
        private static ListenerList LISTENER_LIST;

        public Save(World world) {
            super(world);
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

    public static class Unload
    extends WorldEvent {
        private static ListenerList LISTENER_LIST;

        public Unload(World world) {
            super(world);
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
    extends WorldEvent {
        private static ListenerList LISTENER_LIST;

        public Load(World world) {
            super(world);
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

