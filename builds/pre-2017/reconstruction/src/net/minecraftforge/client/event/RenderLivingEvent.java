/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public abstract class RenderLivingEvent
extends Event {
    public final EntityLivingBase entity;
    public final RendererLivingEntity renderer;
    private static ListenerList LISTENER_LIST;

    public RenderLivingEvent(EntityLivingBase entityLivingBase, RendererLivingEntity rendererLivingEntity) {
        this.entity = entityLivingBase;
        this.renderer = rendererLivingEntity;
    }

    public RenderLivingEvent() {
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

    public static abstract class Specials
    extends RenderLivingEvent {
        private static ListenerList LISTENER_LIST;

        public Specials(EntityLivingBase entityLivingBase, RendererLivingEntity rendererLivingEntity) {
            super(entityLivingBase, rendererLivingEntity);
        }

        public Specials() {
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
        extends Specials {
            private static ListenerList LISTENER_LIST;

            public Post(EntityLivingBase entityLivingBase, RendererLivingEntity rendererLivingEntity) {
                super(entityLivingBase, rendererLivingEntity);
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

        @Cancelable
        public static class Pre
        extends Specials {
            private static ListenerList LISTENER_LIST;

            public Pre(EntityLivingBase entityLivingBase, RendererLivingEntity rendererLivingEntity) {
                super(entityLivingBase, rendererLivingEntity);
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

    public static class Post
    extends RenderLivingEvent {
        private static ListenerList LISTENER_LIST;

        public Post(EntityLivingBase entityLivingBase, RendererLivingEntity rendererLivingEntity) {
            super(entityLivingBase, rendererLivingEntity);
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

    @Cancelable
    public static class Pre
    extends RenderLivingEvent {
        private static ListenerList LISTENER_LIST;

        public Pre(EntityLivingBase entityLivingBase, RendererLivingEntity rendererLivingEntity) {
            super(entityLivingBase, rendererLivingEntity);
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

