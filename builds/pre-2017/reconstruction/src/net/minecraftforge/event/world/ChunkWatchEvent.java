/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class ChunkWatchEvent
extends Event {
    public final jjym chunk;
    public final EntityPlayerMP player;
    private static ListenerList LISTENER_LIST;

    public ChunkWatchEvent(jjym jjym2, EntityPlayerMP entityPlayerMP) {
        this.chunk = jjym2;
        this.player = entityPlayerMP;
    }

    public ChunkWatchEvent() {
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

    public static class UnWatch
    extends ChunkWatchEvent {
        private static ListenerList LISTENER_LIST;

        public UnWatch(jjym jjym2, EntityPlayerMP entityPlayerMP) {
            super(jjym2, entityPlayerMP);
        }

        public UnWatch() {
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

    public static class Watch
    extends ChunkWatchEvent {
        private static ListenerList LISTENER_LIST;

        public Watch(jjym jjym2, EntityPlayerMP entityPlayerMP) {
            super(jjym2, entityPlayerMP);
        }

        public Watch() {
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

