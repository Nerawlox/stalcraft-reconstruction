/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneTorch
extends matb {
    public boolean _a;
    public static Map _b = new HashMap();

    public boolean _a(World world, int n, int n2, int n3, boolean bl) {
        if (!_b.containsKey(world)) {
            _b.put(world, new ArrayList());
        }
        List list = (List)_b.get(world);
        if (bl) {
            list.add(new uzqb(n, n2, n3, world.getTotalWorldTime()));
        }
        int n4 = 0;
        for (int i = 0; i < list.size(); ++i) {
            uzqb uzqb2 = (uzqb)list.get(i);
            if (uzqb2._a != n || uzqb2._b != n2 || uzqb2._c != n3 || ++n4 < 8) continue;
            return true;
        }
        return false;
    }

    public BlockRedstoneTorch(int n, boolean bl) {
        super(n);
        this._a = bl;
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }

    @Override
    public int tickRate(World world) {
        return 2;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        if (world.getBlockMetadata(n, n2, n3) == 0) {
            super.onBlockAdded(world, n, n2, n3);
        }
        if (this._a) {
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
        }
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        if (this._a) {
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
        }
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (!this._a) {
            return 0;
        }
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (n5 == 5 && n4 == 1) {
            return 0;
        }
        if (n5 == 3 && n4 == 3) {
            return 0;
        }
        if (n5 == 4 && n4 == 2) {
            return 0;
        }
        if (n5 == 1 && n4 == 5) {
            return 0;
        }
        if (n5 == 2 && n4 == 4) {
            return 0;
        }
        return 15;
    }

    public boolean _a(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if (n4 == 5 && world.getIndirectPowerOutput(n, n2 - 1, n3, 0)) {
            return true;
        }
        if (n4 == 3 && world.getIndirectPowerOutput(n, n2, n3 - 1, 2)) {
            return true;
        }
        if (n4 == 4 && world.getIndirectPowerOutput(n, n2, n3 + 1, 3)) {
            return true;
        }
        if (n4 == 1 && world.getIndirectPowerOutput(n - 1, n2, n3, 4)) {
            return true;
        }
        return n4 == 2 && world.getIndirectPowerOutput(n + 1, n2, n3, 5);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        boolean bl = this._a(world, n, n2, n3);
        List list = (List)_b.get(world);
        while (list != null && !list.isEmpty() && world.getTotalWorldTime() - ((uzqb)list.get((int)0))._d > 60L) {
            list.remove(0);
        }
        if (this._a) {
            if (bl) {
                world.setBlock(n, n2, n3, Block.torchRedstoneIdle.blockID, world.getBlockMetadata(n, n2, n3), 3);
                if (this._a(world, n, n2, n3, true)) {
                    world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
                    for (int i = 0; i < 5; ++i) {
                        double d = (double)n + random.nextDouble() * 0.6 + 0.2;
                        double d2 = (double)n2 + random.nextDouble() * 0.6 + 0.2;
                        double d3 = (double)n3 + random.nextDouble() * 0.6 + 0.2;
                        world.spawnParticle("smoke", d, d2, d3, 0.0, 0.0, 0.0);
                    }
                }
            }
        } else if (!bl && !this._a(world, n, n2, n3, false)) {
            world.setBlock(n, n2, n3, Block.torchRedstoneActive.blockID, world.getBlockMetadata(n, n2, n3), 3);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (this._a(world, n, n2, n3, n4)) {
            return;
        }
        boolean bl = this._a(world, n, n2, n3);
        if (this._a && bl || !this._a && !bl) {
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        }
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            return this.isProvidingWeakPower(iBlockAccess, n, n2, n3, n4);
        }
        return 0;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.torchRedstoneActive.blockID;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (!this._a) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3);
        double d = (double)((float)n + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d2 = (double)((float)n2 + 0.7f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d3 = (double)((float)n3 + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d4 = 0.22f;
        double d5 = 0.27f;
        if (n4 == 1) {
            world.spawnParticle("reddust", d - d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 2) {
            world.spawnParticle("reddust", d + d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 3) {
            world.spawnParticle("reddust", d, d2 + d4, d3 - d5, 0.0, 0.0, 0.0);
        } else if (n4 == 4) {
            world.spawnParticle("reddust", d, d2 + d4, d3 + d5, 0.0, 0.0, 0.0);
        } else {
            world.spawnParticle("reddust", d, d2, d3, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Block.torchRedstoneActive.blockID;
    }

    @Override
    public boolean isAssociatedBlockID(int n) {
        return n == Block.torchRedstoneIdle.blockID || n == Block.torchRedstoneActive.blockID;
    }
}

