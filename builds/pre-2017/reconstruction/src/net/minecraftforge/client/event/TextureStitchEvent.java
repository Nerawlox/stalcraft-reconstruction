/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class TextureStitchEvent
extends Event {
    public final sctd map;
    private static ListenerList LISTENER_LIST;

    public TextureStitchEvent(sctd sctd2) {
        this.map = sctd2;
    }

    public TextureStitchEvent() {
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

    public static class Post
    extends TextureStitchEvent {
        private static ListenerList LISTENER_LIST;

        public Post(sctd sctd2) {
            super(sctd2);
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
    extends TextureStitchEvent {
        private static ListenerList LISTENER_LIST;

        public Pre(sctd sctd2) {
            super(sctd2);
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

