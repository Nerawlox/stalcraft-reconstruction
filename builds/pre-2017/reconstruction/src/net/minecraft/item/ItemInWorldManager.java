/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

public class ItemInWorldManager {
    public double _a = 5.0;
    public World _b;
    public EntityPlayerMP _c;
    public EnumGameType _d = EnumGameType._a;
    public boolean _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public boolean _k;
    public int _l;
    public int _m;
    public int _n;
    public int _o;
    public int _p = -1;

    public ItemInWorldManager(World world) {
        this._b = world;
    }

    public void _a(EnumGameType enumGameType) {
        this._d = enumGameType;
        enumGameType._a(this._c.capabilities);
        this._c.sendPlayerAbilities();
    }

    public EnumGameType _a() {
        return this._d;
    }

    public boolean _b() {
        return this._d._d();
    }

    public void _b(EnumGameType enumGameType) {
        if (this._d == EnumGameType._a) {
            this._d = enumGameType;
        }
        this._a(this._d);
    }

    public void _c() {
        ++this._j;
        if (this._k) {
            int n = this._j - this._o;
            int n2 = this._b.getBlockId(this._l, this._m, this._n);
            if (n2 == 0) {
                this._k = false;
            } else {
                Block block = Block.blocksList[n2];
                float f = block.getPlayerRelativeBlockHardness(this._c, this._c.worldObj, this._l, this._m, this._n) * (float)(n + 1);
                int n3 = (int)(f * 10.0f);
                if (n3 != this._p) {
                    this._b.destroyBlockInWorldPartially(this._c.entityId, this._l, this._m, this._n, n3);
                    this._p = n3;
                }
                if (f >= 1.0f) {
                    this._k = false;
                    this._d(this._l, this._m, this._n);
                }
            }
        } else if (this._e) {
            int n = this._b.getBlockId(this._g, this._h, this._i);
            Block block = Block.blocksList[n];
            if (block == null) {
                this._b.destroyBlockInWorldPartially(this._c.entityId, this._g, this._h, this._i, -1);
                this._p = -1;
                this._e = false;
            } else {
                int n4 = this._j - this._f;
                float f = block.getPlayerRelativeBlockHardness(this._c, this._c.worldObj, this._g, this._h, this._i) * (float)(n4 + 1);
                int n5 = (int)(f * 10.0f);
                if (n5 != this._p) {
                    this._b.destroyBlockInWorldPartially(this._c.entityId, this._g, this._h, this._i, n5);
                    this._p = n5;
                }
            }
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        if (!this._d._c() || this._c.isCurrentToolAdventureModeExempt(n, n2, n3)) {
            PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(this._c, PlayerInteractEvent.Action.LEFT_CLICK_BLOCK, n, n2, n3, n4);
            if (playerInteractEvent.isCanceled()) {
                this._c.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, this._b));
                return;
            }
            if (this._b()) {
                if (!this._b.extinguishFire(null, n, n2, n3, n4)) {
                    this._d(n, n2, n3);
                }
            } else {
                this._f = this._j;
                float f = 1.0f;
                int n5 = this._b.getBlockId(n, n2, n3);
                Block block = Block.blocksList[n5];
                if (block != null) {
                    if (playerInteractEvent.useBlock != Event.Result.DENY) {
                        block.onBlockClicked(this._b, n, n2, n3, this._c);
                        this._b.extinguishFire(this._c, n, n2, n3, n4);
                    } else {
                        this._c.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, this._b));
                    }
                    f = block.getPlayerRelativeBlockHardness(this._c, this._c.worldObj, n, n2, n3);
                }
                if (playerInteractEvent.useItem == Event.Result.DENY) {
                    if (f >= 1.0f) {
                        this._c.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, this._b));
                    }
                    return;
                }
                if (n5 > 0 && f >= 1.0f) {
                    this._d(n, n2, n3);
                } else {
                    this._e = true;
                    this._g = n;
                    this._h = n2;
                    this._i = n3;
                    int n6 = (int)(f * 10.0f);
                    this._b.destroyBlockInWorldPartially(this._c.entityId, n, n2, n3, n6);
                    this._p = n6;
                }
            }
        }
    }

    public void _a(int n, int n2, int n3) {
        if (n == this._g && n2 == this._h && n3 == this._i) {
            int n4 = this._j - this._f;
            int n5 = this._b.getBlockId(n, n2, n3);
            if (n5 != 0) {
                Block block = Block.blocksList[n5];
                float f = block.getPlayerRelativeBlockHardness(this._c, this._c.worldObj, n, n2, n3) * (float)(n4 + 1);
                if (f >= 0.7f) {
                    this._e = false;
                    this._b.destroyBlockInWorldPartially(this._c.entityId, n, n2, n3, -1);
                    this._d(n, n2, n3);
                } else if (!this._k) {
                    this._e = false;
                    this._k = true;
                    this._l = n;
                    this._m = n2;
                    this._n = n3;
                    this._o = this._f;
                }
            }
        }
    }

    public void _b(int n, int n2, int n3) {
        this._e = false;
        this._b.destroyBlockInWorldPartially(this._c.entityId, this._g, this._h, this._i, -1);
    }

    public boolean _c(int n, int n2, int n3) {
        boolean bl;
        Block block = Block.blocksList[this._b.getBlockId(n, n2, n3)];
        int n4 = this._b.getBlockMetadata(n, n2, n3);
        if (block != null) {
            block.onBlockHarvested(this._b, n, n2, n3, n4, this._c);
        }
        boolean bl2 = bl = block != null && block.removeBlockByPlayer(this._b, this._c, n, n2, n3);
        if (block != null && bl) {
            block.onBlockDestroyedByPlayer(this._b, n, n2, n3, n4);
        }
        return bl;
    }

    public boolean _d(int n, int n2, int n3) {
        BlockEvent.BreakEvent breakEvent = ForgeHooks.onBlockBreakEvent(this._b, this._d, this._c, n, n2, n3);
        if (breakEvent.isCanceled()) {
            return false;
        }
        ItemStack itemStack = this._c.getCurrentEquippedItem();
        if (itemStack != null && itemStack._a().onBlockStartBreak(itemStack, n, n2, n3, this._c)) {
            return false;
        }
        int n4 = this._b.getBlockId(n, n2, n3);
        int n5 = this._b.getBlockMetadata(n, n2, n3);
        this._b.playAuxSFXAtEntity(this._c, 2001, n, n2, n3, n4 + (this._b.getBlockMetadata(n, n2, n3) << 12));
        boolean bl = false;
        if (this._b()) {
            bl = this._c(n, n2, n3);
            this._c.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, this._b));
        } else {
            ItemStack itemStack2 = this._c.getCurrentEquippedItem();
            boolean bl2 = false;
            Block block = Block.blocksList[n4];
            if (block != null) {
                bl2 = block.canHarvestBlock(this._c, n5);
            }
            if (itemStack2 != null) {
                itemStack2._a(this._b, n4, n, n2, n3, this._c);
                if (itemStack2._b == 0) {
                    this._c.destroyCurrentEquippedItem();
                }
            }
            if ((bl = this._c(n, n2, n3)) && bl2) {
                Block.blocksList[n4].harvestBlock(this._b, this._c, n, n2, n3, n5);
            }
        }
        if (!this._b() && bl && breakEvent != null) {
            Block.blocksList[n4].dropXpOnBlockBreak(this._b, n, n2, n3, breakEvent.getExpToDrop());
        }
        return bl;
    }

    public boolean _a(EntityPlayer entityPlayer, World world, ItemStack itemStack) {
        int n = itemStack._b;
        int n2 = itemStack._j();
        ItemStack itemStack2 = itemStack._a(world, entityPlayer);
        if (itemStack2 == itemStack && (itemStack2 == null || itemStack2._b == n && itemStack2._n() <= 0 && itemStack2._j() == n2)) {
            return false;
        }
        entityPlayer.inventory._a[entityPlayer.inventory._c] = itemStack2;
        if (this._b()) {
            itemStack2._b = n;
            if (itemStack2._f()) {
                itemStack2._b(n2);
            }
        }
        if (itemStack2._b == 0) {
            entityPlayer.inventory._a[entityPlayer.inventory._c] = null;
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this._c, itemStack2));
        }
        if (!entityPlayer.isUsingItem()) {
            ((EntityPlayerMP)entityPlayer).sendContainerToPlayer(entityPlayer.inventoryContainer);
        }
        return true;
    }

    public boolean _a(EntityPlayer entityPlayer, World world, ItemStack itemStack, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        Item item;
        PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(entityPlayer, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, n, n2, n3, n4);
        if (playerInteractEvent.isCanceled()) {
            this._c.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, this._b));
            return false;
        }
        Item item2 = item = itemStack != null ? itemStack._a() : null;
        if (item != null && item.onItemUseFirst(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3)) {
            if (itemStack._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(this._c, itemStack);
            }
            return true;
        }
        int n5 = world.getBlockId(n, n2, n3);
        Block block = Block.blocksList[n5];
        boolean bl = false;
        if (block != null && (!entityPlayer.isSneaking() || entityPlayer.getHeldItem() == null || entityPlayer.getHeldItem()._a().shouldPassSneakingClickToBlock(world, n, n2, n3))) {
            if (playerInteractEvent.useBlock != Event.Result.DENY) {
                bl = block.onBlockActivated(world, n, n2, n3, entityPlayer, n4, f, f2, f3);
            } else {
                this._c.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, this._b));
                boolean bl2 = bl = playerInteractEvent.useItem != Event.Result.ALLOW;
            }
        }
        if (itemStack != null && !bl && playerInteractEvent.useItem != Event.Result.DENY) {
            int n6 = itemStack._j();
            int n7 = itemStack._b;
            bl = itemStack._a(entityPlayer, world, n, n2, n3, n4, f, f2, f3);
            if (this._b()) {
                itemStack._b(n6);
                itemStack._b = n7;
            }
            if (itemStack._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(this._c, itemStack);
            }
        }
        return bl;
    }

    public void _a(WorldServer worldServer) {
        this._b = worldServer;
    }

    public double _d() {
        return this._a;
    }

    public void _a(double d) {
        this._a = d;
    }
}

