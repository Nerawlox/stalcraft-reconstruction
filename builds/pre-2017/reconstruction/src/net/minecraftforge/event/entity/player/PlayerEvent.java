/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PlayerEvent
extends LivingEvent {
    public final EntityPlayer entityPlayer;
    private static ListenerList LISTENER_LIST;

    public PlayerEvent(EntityPlayer entityPlayer) {
        super(entityPlayer);
        this.entityPlayer = entityPlayer;
    }

    public PlayerEvent() {
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

    public static class NameFormat
    extends PlayerEvent {
        public final String username;
        public String displayname;
        private static ListenerList LISTENER_LIST;

        public NameFormat(EntityPlayer entityPlayer, String string) {
            super(entityPlayer);
            this.username = string;
            this.displayname = string;
        }

        public NameFormat() {
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
    public static class BreakSpeed
    extends PlayerEvent {
        public final Block block;
        public final int metadata;
        public final float originalSpeed;
        public float newSpeed;
        private static ListenerList LISTENER_LIST;

        public BreakSpeed(EntityPlayer entityPlayer, Block block, int n, float f) {
            super(entityPlayer);
            this.newSpeed = 0.0f;
            this.block = block;
            this.metadata = n;
            this.originalSpeed = f;
            this.newSpeed = f;
        }

        public BreakSpeed() {
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

    public static class HarvestCheck
    extends PlayerEvent {
        public final Block block;
        public boolean success;
        private static ListenerList LISTENER_LIST;

        public HarvestCheck(EntityPlayer entityPlayer, Block block, boolean bl) {
            super(entityPlayer);
            this.block = block;
            this.success = bl;
        }

        public HarvestCheck() {
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

