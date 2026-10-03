/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.event;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;

public abstract class RenderPlayerEvent
extends PlayerEvent {
    public final RenderPlayer renderer;
    public final float partialRenderTick;
    private static ListenerList LISTENER_LIST;

    public RenderPlayerEvent(EntityPlayer entityPlayer, RenderPlayer renderPlayer, float f) {
        super(entityPlayer);
        this.renderer = renderPlayer;
        this.partialRenderTick = f;
    }

    public RenderPlayerEvent() {
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

    public static class SetArmorModel
    extends RenderPlayerEvent {
        public int result;
        public final int slot;
        @Deprecated
        public final float partialTick;
        public final ItemStack stack;
        private static ListenerList LISTENER_LIST;

        public SetArmorModel(EntityPlayer entityPlayer, RenderPlayer renderPlayer, int n, float f, ItemStack itemStack) {
            super(entityPlayer, renderPlayer, f);
            this.result = -1;
            this.slot = n;
            this.partialTick = f;
            this.stack = itemStack;
        }

        public SetArmorModel() {
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

    public static abstract class Specials
    extends RenderPlayerEvent {
        @Deprecated
        public final float partialTicks;
        private static ListenerList LISTENER_LIST;

        public Specials(EntityPlayer entityPlayer, RenderPlayer renderPlayer, float f) {
            super(entityPlayer, renderPlayer, f);
            this.partialTicks = f;
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

            public Post(EntityPlayer entityPlayer, RenderPlayer renderPlayer, float f) {
                super(entityPlayer, renderPlayer, f);
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
            public boolean renderHelmet;
            public boolean renderCape;
            public boolean renderItem;
            private static ListenerList LISTENER_LIST;

            public Pre(EntityPlayer entityPlayer, RenderPlayer renderPlayer, float f) {
                super(entityPlayer, renderPlayer, f);
                this.renderHelmet = true;
                this.renderCape = true;
                this.renderItem = true;
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
    extends RenderPlayerEvent {
        private static ListenerList LISTENER_LIST;

        public Post(EntityPlayer entityPlayer, RenderPlayer renderPlayer, float f) {
            super(entityPlayer, renderPlayer, f);
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
    extends RenderPlayerEvent {
        private static ListenerList LISTENER_LIST;

        public Pre(EntityPlayer entityPlayer, RenderPlayer renderPlayer, float f) {
            super(entityPlayer, renderPlayer, f);
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

