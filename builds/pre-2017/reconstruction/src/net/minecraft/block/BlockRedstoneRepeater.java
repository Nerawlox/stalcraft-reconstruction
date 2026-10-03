/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLogic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneRepeater
extends BlockRedstoneLogic {
    public static final double[] _b = new double[]{-0.0625, 0.0625, 0.1875, 0.3125};
    public static final int[] _c = new int[]{1, 2, 3, 4};

    public BlockRedstoneRepeater(int n, boolean bl) {
        super(n, bl);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        int n6 = (n5 & 0xC) >> 2;
        n6 = n6 + 1 << 2 & 0xC;
        world.func_72921_c(n, n2, n3, n6 | n5 & 3, 3);
        return true;
    }

    @Override
    public int _a(int n) {
        return _c[(n & 0xC) >> 2] * 2;
    }

    @Override
    public BlockRedstoneLogic _a() {
        return Block.redstoneRepeaterActive;
    }

    @Override
    public BlockRedstoneLogic _b() {
        return Block.redstoneRepeaterIdle;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.redstoneRepeater.itemID;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.redstoneRepeater.itemID;
    }

    @Override
    public int getRenderType() {
        return 15;
    }

    @Override
    public boolean _b(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this._c(iBlockAccess, n, n2, n3, n4) > 0;
    }

    @Override
    public boolean _e(int n) {
        return BlockRedstoneRepeater._f(n);
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (!this._a) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = BlockRedstoneRepeater._d(n4);
        double d = (double)((float)n + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d2 = (double)((float)n2 + 0.4f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d3 = (double)((float)n3 + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d4 = 0.0;
        double d5 = 0.0;
        if (random.nextInt(2) == 0) {
            switch (n5) {
                case 0: {
                    d5 = -0.3125;
                    break;
                }
                case 2: {
                    d5 = 0.3125;
                    break;
                }
                case 3: {
                    d4 = -0.3125;
                    break;
                }
                case 1: {
                    d4 = 0.3125;
                }
            }
        } else {
            int n6 = (n4 & 0xC) >> 2;
            switch (n5) {
                case 0: {
                    d5 = _b[n6];
                    break;
                }
                case 2: {
                    d5 = -_b[n6];
                    break;
                }
                case 3: {
                    d4 = _b[n6];
                    break;
                }
                case 1: {
                    d4 = -_b[n6];
                }
            }
        }
        world.spawnParticle("reddust", d + d4, d2, d3 + d5, 0.0, 0.0, 0.0);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        super.breakBlock(world, n, n2, n3, n4, n5);
        this._a(world, n, n2, n3);
    }
}

