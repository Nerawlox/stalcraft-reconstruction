/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.world;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class BlockEvent
extends Event {
    public final int x;
    public final int y;
    public final int z;
    public final World world;
    public final Block block;
    public final int blockMetadata;
    private static ListenerList LISTENER_LIST;

    public BlockEvent(int n, int n2, int n3, World world, Block block, int n4) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.world = world;
        this.block = block;
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

        public BreakEvent(int n, int n2, int n3, World world, Block block, int n4, EntityPlayer entityPlayer) {
            super(n, n2, n3, world, block, n4);
            this.player = entityPlayer;
            if (block == null || !entityPlayer.canHarvestBlock(block) || block.canSilkHarvest(world, entityPlayer, n, n2, n3, n4) && zhty._d(entityPlayer)) {
                this.exp = 0;
            } else {
                int n5 = block.getDamageValue(world, n, n2, n3);
                int n6 = zhty._e(entityPlayer);
                this.exp = block.getExpDrop(world, n5, n6);
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
        public final ArrayList<ItemStack> drops;
        public final boolean isSilkTouching;
        public float dropChance;
        public final EntityPlayer harvester;
        private static ListenerList LISTENER_LIST;

        public HarvestDropsEvent(int n, int n2, int n3, World world, Block block, int n4, int n5, float f, ArrayList<ItemStack> arrayList, EntityPlayer entityPlayer, boolean bl) {
            super(n, n2, n3, world, block, n4);
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

