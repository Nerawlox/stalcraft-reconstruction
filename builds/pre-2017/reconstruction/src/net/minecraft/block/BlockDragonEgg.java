/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDragonEgg
extends Block {
    public BlockDragonEgg(int n) {
        super(n, Material._C);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        this._a(world, n, n2, n3);
    }

    public void _a(World world, int n, int n2, int n3) {
        if (uilx._b(world, n, n2 - 1, n3) && n2 >= 0) {
            int n4 = 32;
            if (uilx._e || !world.checkChunksExist(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4)) {
                world.setBlockToAir(n, n2, n3);
                while (uilx._b(world, n, n2 - 1, n3) && n2 > 0) {
                    --n2;
                }
                if (n2 > 0) {
                    world.setBlock(n, n2, n3, this.blockID, 0, 2);
                }
            } else {
                EntityFallingSand entityFallingSand = new EntityFallingSand(world, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this.blockID);
                world.spawnEntityInWorld(entityFallingSand);
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        this._b(world, n, n2, n3);
        return true;
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._b(world, n, n2, n3);
    }

    public void _b(World world, int n, int n2, int n3) {
        if (world.getBlockId(n, n2, n3) != this.blockID) {
            return;
        }
        for (int i = 0; i < 1000; ++i) {
            int n4;
            int n5;
            int n6 = n + world.rand.nextInt(16) - world.rand.nextInt(16);
            if (world.getBlockId(n6, n5 = n2 + world.rand.nextInt(8) - world.rand.nextInt(8), n4 = n3 + world.rand.nextInt(16) - world.rand.nextInt(16)) != 0) continue;
            if (!world.isRemote) {
                world.setBlock(n6, n5, n4, this.blockID, world.getBlockMetadata(n, n2, n3), 2);
                world.setBlockToAir(n, n2, n3);
            } else {
                int n7 = 128;
                for (int j = 0; j < n7; ++j) {
                    double d = world.rand.nextDouble();
                    float f = (world.rand.nextFloat() - 0.5f) * 0.2f;
                    float f2 = (world.rand.nextFloat() - 0.5f) * 0.2f;
                    float f3 = (world.rand.nextFloat() - 0.5f) * 0.2f;
                    double d2 = (double)n6 + (double)(n - n6) * d + (world.rand.nextDouble() - 0.5) * 1.0 + 0.5;
                    double d3 = (double)n5 + (double)(n2 - n5) * d + world.rand.nextDouble() * 1.0 - 0.5;
                    double d4 = (double)n4 + (double)(n3 - n4) * d + (world.rand.nextDouble() - 0.5) * 1.0 + 0.5;
                    world.spawnParticle("portal", d2, d3, d4, f, f2, f3);
                }
            }
            return;
        }
    }

    @Override
    public int tickRate(World world) {
        return 5;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int getRenderType() {
        return 27;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return 0;
    }
}

