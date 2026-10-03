/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.owak;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonMoving
extends BlockContainer {
    public BlockPistonMoving(int n) {
        super(n, Material._G);
        this.setHardness(-1.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity instanceof TileEntityPiston) {
            ((TileEntityPiston)tileEntity)._e();
        } else {
            super.breakBlock(world, n, n2, n3, n4, n5);
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return false;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
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
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!world.isRemote && world.getBlockTileEntity(n, n2, n3) == null) {
            world.setBlockToAir(n, n2, n3);
            return true;
        }
        return false;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        if (world.isRemote) {
            return;
        }
        TileEntityPiston tileEntityPiston = this._a(world, n, n2, n3);
        if (tileEntityPiston == null) {
            return;
        }
        Block.blocksList[tileEntityPiston._a()].dropBlockAsItem(world, n, n2, n3, tileEntityPiston.getBlockMetadata(), 0);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            world.getBlockTileEntity(n, n2, n3);
        }
    }

    public static TileEntity _a(int n, int n2, int n3, boolean bl, boolean bl2) {
        return new TileEntityPiston(n, n2, n3, bl, bl2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        TileEntityPiston tileEntityPiston = this._a(world, n, n2, n3);
        if (tileEntityPiston == null) {
            return null;
        }
        float f = tileEntityPiston._a(0.0f);
        if (tileEntityPiston._b()) {
            f = 1.0f - f;
        }
        return this._a(world, n, n2, n3, tileEntityPiston._a(), f, tileEntityPiston._c());
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TileEntityPiston tileEntityPiston = this._a(iBlockAccess, n, n2, n3);
        if (tileEntityPiston != null) {
            Block block = Block.blocksList[tileEntityPiston._a()];
            if (block == null || block == this) {
                return;
            }
            block.setBlockBoundsBasedOnState(iBlockAccess, n, n2, n3);
            float f = tileEntityPiston._a(0.0f);
            if (tileEntityPiston._b()) {
                f = 1.0f - f;
            }
            int n4 = tileEntityPiston._c();
            this.minX = block.func_83009_v() - (double)((float)owak._b[n4] * f);
            this.minY = block.getBlockBoundsMinY() - (double)((float)owak._c[n4] * f);
            this.minZ = block.getBlockBoundsMinZ() - (double)((float)owak._d[n4] * f);
            this.maxX = block.getBlockBoundsMaxX() - (double)((float)owak._b[n4] * f);
            this.maxY = block.getBlockBoundsMaxY() - (double)((float)owak._c[n4] * f);
            this.maxZ = block.getBlockBoundsMaxZ() - (double)((float)owak._d[n4] * f);
        }
    }

    public AxisAlignedBB _a(World world, int n, int n2, int n3, int n4, float f, int n5) {
        if (n4 == 0 || n4 == this.blockID) {
            return null;
        }
        AxisAlignedBB axisAlignedBB = Block.blocksList[n4].getCollisionBoundingBoxFromPool(world, n, n2, n3);
        if (axisAlignedBB == null) {
            return null;
        }
        if (owak._b[n5] < 0) {
            axisAlignedBB._b -= (double)((float)owak._b[n5] * f);
        } else {
            axisAlignedBB._e -= (double)((float)owak._b[n5] * f);
        }
        if (owak._c[n5] < 0) {
            axisAlignedBB._c -= (double)((float)owak._c[n5] * f);
        } else {
            axisAlignedBB._f -= (double)((float)owak._c[n5] * f);
        }
        if (owak._d[n5] < 0) {
            axisAlignedBB._d -= (double)((float)owak._d[n5] * f);
        } else {
            axisAlignedBB._g -= (double)((float)owak._d[n5] * f);
        }
        return axisAlignedBB;
    }

    public TileEntityPiston _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TileEntity tileEntity = iBlockAccess.getBlockTileEntity(n, n2, n3);
        if (tileEntity instanceof TileEntityPiston) {
            return (TileEntityPiston)tileEntity;
        }
        return null;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return 0;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("piston_top_normal");
    }
}

