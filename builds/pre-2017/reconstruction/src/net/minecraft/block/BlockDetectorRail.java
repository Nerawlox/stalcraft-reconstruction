/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDetectorRail
extends BlockRailBase {
    public Icon[] _a;

    public BlockDetectorRail(int n) {
        super(n, true);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(World world) {
        return 20;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (world.isRemote) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3);
        if ((n4 & 8) != 0) {
            return;
        }
        this._a(world, n, n2, n3, n4);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.isRemote) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3);
        if ((n4 & 8) == 0) {
            return;
        }
        this._a(world, n, n2, n3, n4);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return (iBlockAccess.getBlockMetadata(n, n2, n3) & 8) != 0 ? 15 : 0;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if ((iBlockAccess.getBlockMetadata(n, n2, n3) & 8) == 0) {
            return 0;
        }
        return n4 == 1 ? 15 : 0;
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
        boolean bl = (n4 & 8) != 0;
        boolean bl2 = false;
        float f = 0.125f;
        List list2 = world.getEntitiesWithinAABB(EntityMinecart.class, AxisAlignedBB._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (float)(n2 + 1) - f, (float)(n3 + 1) - f));
        if (!list2.isEmpty()) {
            bl2 = true;
        }
        if (bl2 && !bl) {
            world.func_72921_c(n, n2, n3, n4 | 8, 3);
            world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
        }
        if (!bl2 && bl) {
            world.func_72921_c(n, n2, n3, n4 & 7, 3);
            world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.markBlockRangeForRenderUpdate(n, n2, n3, n, n2, n3);
        }
        if (bl2) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        }
        world.func_96440_m(n, n2, n3, this.blockID);
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        this._a(world, n, n2, n3, world.getBlockMetadata(n, n2, n3));
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        if ((world.getBlockMetadata(n, n2, n3) & 8) > 0) {
            float f = 0.125f;
            List list2 = world.selectEntitiesWithinAABB(EntityMinecart.class, AxisAlignedBB._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (float)(n2 + 1) - f, (float)(n3 + 1) - f), IEntitySelector._b);
            if (list2.size() > 0) {
                return Container.calcRedstoneFromInventory((IInventory)list2.get(0));
            }
        }
        return 0;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._a = new Icon[2];
        this._a[0] = iconRegister._b(this.getTextureName());
        this._a[1] = iconRegister._b(this.getTextureName() + "_powered");
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if ((n2 & 8) != 0) {
            return this._a[1];
        }
        return this._a[0];
    }
}

