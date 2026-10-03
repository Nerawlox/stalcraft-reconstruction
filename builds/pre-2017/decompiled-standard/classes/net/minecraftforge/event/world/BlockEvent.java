/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class BlockEvent
extends Event {
    public final int x;
    public final int y;
    public final int z;
    public final ozlu world;
    public final twgu block;
    public final int blockMetadata;
    private static ListenerList LISTENER_LIST;

    public BlockEvent(int n, int n2, int n3, ozlu ozlu2, twgu twgu2, int n4) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.world = ozlu2;
        this.block = twgu2;
        this.blockMetadata = n4;
    }

    public BlockEvent() {
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
    public static class BreakEvent
    extends BlockEvent {
        private final EntityPlayer player;
        private int exp;
        private static ListenerList LISTENER_LIST;

        public BreakEvent(int n, int n2, int n3, ozlu ozlu2, twgu twgu2, int n4, EntityPlayer entityPlayer) {
            super(n, n2, n3, ozlu2, twgu2, n4);
            this.player = entityPlayer;
            if (twgu2 == null || !entityPlayer.func_71062_b(twgu2) || twgu2.canSilkHarvest(ozlu2, entityPlayer, n, n2, n3, n4) && zhty._d(entityPlayer)) {
                this.exp = 0;
            } else {
                int n5 = twgu2.func_71873_h(ozlu2, n, n2, n3);
                int n6 = zhty._e(entityPlayer);
                this.exp = twgu2.getExpDrop(ozlu2, n5, n6);
            }
        }

        public EntityPlayer getPlayer() {
            return this.player;
        }

        public int getExpToDrop() {
            return this.isCanceled() ? 0 : this.exp;
        }

        public void setExpToDrop(int n) {
            this.exp = n;
        }

        public BreakEvent() {
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

    public static class HarvestDropsEvent
    extends BlockEvent {
        public final int fortuneLevel;
        public final ArrayList<cvzo> drops;
        public final boolean isSilkTouching;
        public float dropChance;
        public final EntityPlayer harvester;
        private static ListenerList LISTENER_LIST;

        public HarvestDropsEvent(int n, int n2, int n3, ozlu ozlu2, twgu twgu2, int n4, int n5, float f, ArrayList<cvzo> arrayList, EntityPlayer entityPlayer, boolean bl) {
            super(n, n2, n3, ozlu2, twgu2, n4);
            this.fortuneLevel = n5;
            this.dropChance = f;
            this.drops = arrayList;
            this.isSilkTouching = bl;
            this.harvester = entityPlayer;
        }

        public HarvestDropsEvent() {
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

