/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import java.util.ArrayList;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class RenderGameOverlayEvent
extends Event {
    public final float partialTicks;
    public final htou resolution;
    public final int mouseX;
    public final int mouseY;
    public final ElementType type;
    private static ListenerList LISTENER_LIST;

    public RenderGameOverlayEvent(float f, htou htou2, int n, int n2) {
        this.partialTicks = f;
        this.resolution = htou2;
        this.mouseX = n;
        this.mouseY = n2;
        this.type = null;
    }

    private RenderGameOverlayEvent(RenderGameOverlayEvent renderGameOverlayEvent, ElementType elementType) {
        this.partialTicks = renderGameOverlayEvent.partialTicks;
        this.resolution = renderGameOverlayEvent.resolution;
        this.mouseX = renderGameOverlayEvent.mouseX;
        this.mouseY = renderGameOverlayEvent.mouseY;
        this.type = elementType;
    }

    public RenderGameOverlayEvent() {
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

    public static class Chat
    extends Pre {
        public int posX;
        public int posY;
        private static ListenerList LISTENER_LIST;

        public Chat(RenderGameOverlayEvent renderGameOverlayEvent, int n, int n2) {
            super(renderGameOverlayEvent, ElementType.CHAT);
            this.posX = n;
            this.posY = n2;
        }

        public Chat() {
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

    public static class Text
    extends Pre {
        public final ArrayList<String> left;
        public final ArrayList<String> right;
        private static ListenerList LISTENER_LIST;

        public Text(RenderGameOverlayEvent renderGameOverlayEvent, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            super(renderGameOverlayEvent, ElementType.TEXT);
            this.left = arrayList;
            this.right = arrayList2;
        }

        public Text() {
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

    public static class Post
    extends RenderGameOverlayEvent {
        private static ListenerList LISTENER_LIST;

        public Post(RenderGameOverlayEvent renderGameOverlayEvent, ElementType elementType) {
            super(renderGameOverlayEvent, elementType);
        }

        @Override
        public boolean isCancelable() {
            return false;
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
    extends RenderGameOverlayEvent {
        private static ListenerList LISTENER_LIST;

        public Pre(RenderGameOverlayEvent renderGameOverlayEvent, ElementType elementType) {
            super(renderGameOverlayEvent, elementType);
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

    public static enum ElementType {
        ALL,
        HELMET,
        PORTAL,
        CROSSHAIRS,
        BOSSHEALTH,
        ARMOR,
        HEALTH,
        FOOD,
        AIR,
        HOTBAR,
        EXPERIENCE,
        TEXT,
        HEALTHMOUNT,
        JUMPBAR,
        CHAT,
        PLAYER_LIST;

    }
}

