/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.jxsn;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class WorldEvent
extends Event {
    public final ozlu world;
    private static ListenerList LISTENER_LIST;

    public WorldEvent(ozlu ozlu2) {
        this.world = ozlu2;
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
        public final jxsn type;
        public final int x;
        public final int y;
        public final int z;
        public final List<yffo> list;
        private static ListenerList LISTENER_LIST;

        public PotentialSpawns(ozlu ozlu2, jxsn jxsn2, int n, int n2, int n3, List list2) {
            super(ozlu2);
            this.x = n;
            this.y = n2;
            this.z = n3;
            this.type = jxsn2;
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

        public Save(ozlu ozlu2) {
            super(ozlu2);
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

        public Unload(ozlu ozlu2) {
            super(ozlu2);
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

        public Load(ozlu ozlu2) {
            super(ozlu2);
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

