/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.util.ugqx;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBed
extends BlockDirectional {
    public static final int[][] _a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public Icon[] _b;
    public Icon[] _c;
    public Icon[] _d;

    public BlockBed(int n) {
        super(n, Material._n);
        this._a();
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        qlgf._a(this, world, n, n2, n3, entityPlayer, n4, f, f2, f3);
        return false;
    }

    @Override
    public Icon getIcon(int n, int n2) {
        int n3;
        if (n == 0) {
            return Block.planks.getBlockTextureFromSide(n);
        }
        int n4 = BlockBed._d(n2);
        int n5 = ugqx._i[n4][n];
        int n6 = n3 = BlockBed._a(n2) ? 1 : 0;
        if (n3 == 1 && n5 == 2 || n3 == 0 && n5 == 3) {
            return this._b[n3];
        }
        if (n5 == 5 || n5 == 4) {
            return this._c[n3];
        }
        return this._d[n3];
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._d = new Icon[]{iconRegister._b(this.getTextureName() + "_feet_top"), iconRegister._b(this.getTextureName() + "_head_top")};
        this._b = new Icon[]{iconRegister._b(this.getTextureName() + "_feet_end"), iconRegister._b(this.getTextureName() + "_head_end")};
        this._c = new Icon[]{iconRegister._b(this.getTextureName() + "_feet_side"), iconRegister._b(this.getTextureName() + "_head_side")};
    }

    @Override
    public int getRenderType() {
        return 14;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this._a();
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        int n6 = BlockBed._d(n5);
        if (BlockBed._a(n5)) {
            if (world.getBlockId(n - _a[n6][0], n2, n3 - _a[n6][1]) != this.blockID) {
                world.setBlockToAir(n, n2, n3);
            }
        } else if (world.getBlockId(n + _a[n6][0], n2, n3 + _a[n6][1]) != this.blockID) {
            world.setBlockToAir(n, n2, n3);
            if (!world.isRemote) {
                this.dropBlockAsItem(world, n, n2, n3, n5, 0);
            }
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        if (BlockBed._a(n)) {
            return 0;
        }
        return Item.bed.itemID;
    }

    public void _a() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5625f, 1.0f);
    }

    public static boolean _a(int n) {
        return (n & 8) != 0;
    }

    public static boolean _b(int n) {
        return (n & 4) != 0;
    }

    public static void _a(World world, int n, int n2, int n3, boolean bl) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        n4 = bl ? (n4 |= 4) : (n4 &= 0xFFFFFFFB);
        world.func_72921_c(n, n2, n3, n4, 4);
    }

    public static ChunkCoordinates _a(World world, int n, int n2, int n3, int n4) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        int n6 = BlockDirectional._d(n5);
        for (int i = 0; i <= 1; ++i) {
            int n7 = n - _a[n6][0] * i - 1;
            int n8 = n3 - _a[n6][1] * i - 1;
            int n9 = n7 + 2;
            int n10 = n8 + 2;
            for (int j = n7; j <= n9; ++j) {
                for (int k = n8; k <= n10; ++k) {
                    if (!world.doesBlockHaveSolidTopSurface(j, n2 - 1, k) || world.getBlockMaterial(j, n2, k)._k() || world.getBlockMaterial(j, n2 + 1, k)._k()) continue;
                    if (n4 > 0) {
                        --n4;
                        continue;
                    }
                    return new ChunkCoordinates(j, n2, k);
                }
            }
        }
        return null;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        if (!BlockBed._a(n4)) {
            super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, 0);
        }
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Item.bed.itemID;
    }

    @Override
    public void onBlockHarvested(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        int n5;
        if (entityPlayer.capabilities._d && BlockBed._a(n4) && world.getBlockId(n -= _a[n5 = BlockBed._d(n4)][0], n2, n3 -= _a[n5][1]) == this.blockID) {
            world.setBlockToAir(n, n2, n3);
        }
    }
}

