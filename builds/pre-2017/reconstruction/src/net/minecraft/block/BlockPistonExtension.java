/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.owak;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonExtension
extends Block {
    public Icon _a;

    public BlockPistonExtension(int n) {
        super(n, Material._G);
        this.setStepSound(soundStoneFootstep);
        this.setHardness(0.5f);
    }

    public void _a(Icon icon) {
        this._a = icon;
    }

    public void _a() {
        this._a = null;
    }

    @Override
    public void onBlockHarvested(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        int n5;
        int n6;
        if (entityPlayer.capabilities._d && ((n6 = world.getBlockId(n - owak._b[n5 = BlockPistonExtension._a(n4)], n2 - owak._c[n5], n3 - owak._d[n5])) == Block.pistonBase.blockID || n6 == Block.pistonStickyBase.blockID)) {
            world.setBlockToAir(n - owak._b[n5], n2 - owak._c[n5], n3 - owak._d[n5]);
        }
        super.onBlockHarvested(world, n, n2, n3, n4, entityPlayer);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        super.breakBlock(world, n, n2, n3, n4, n5);
        int n6 = owak._a[BlockPistonExtension._a(n5)];
        int n7 = world.getBlockId(n += owak._b[n6], n2 += owak._c[n6], n3 += owak._d[n6]);
        if ((n7 == Block.pistonBase.blockID || n7 == Block.pistonStickyBase.blockID) && BlockPistonBase._b(n5 = world.getBlockMetadata(n, n2, n3))) {
            Block.blocksList[n7].dropBlockAsItem(world, n, n2, n3, n5, 0);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public Icon getIcon(int n, int n2) {
        int n3 = BlockPistonExtension._a(n2);
        if (n == n3) {
            if (this._a != null) {
                return this._a;
            }
            if ((n2 & 8) != 0) {
                return BlockPistonBase._a("piston_top_sticky");
            }
            return BlockPistonBase._a("piston_top_normal");
        }
        if (n3 < 6 && n == owak._a[n3]) {
            return BlockPistonBase._a("piston_top_normal");
        }
        return BlockPistonBase._a("piston_side");
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }

    @Override
    public int getRenderType() {
        return 17;
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
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return false;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        float f = 0.25f;
        float f2 = 0.375f;
        float f3 = 0.625f;
        float f4 = 0.25f;
        float f5 = 0.75f;
        switch (BlockPistonExtension._a(n4)) {
            case 0: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                this.setBlockBounds(0.375f, 0.25f, 0.375f, 0.625f, 1.0f, 0.625f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                break;
            }
            case 1: {
                this.setBlockBounds(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                this.setBlockBounds(0.375f, 0.0f, 0.375f, 0.625f, 0.75f, 0.625f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                break;
            }
            case 2: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                this.setBlockBounds(0.25f, 0.375f, 0.25f, 0.75f, 0.625f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                break;
            }
            case 3: {
                this.setBlockBounds(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                this.setBlockBounds(0.25f, 0.375f, 0.0f, 0.75f, 0.625f, 0.75f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                break;
            }
            case 4: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                this.setBlockBounds(0.375f, 0.25f, 0.25f, 0.625f, 0.75f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                break;
            }
            case 5: {
                this.setBlockBounds(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
                this.setBlockBounds(0.0f, 0.375f, 0.25f, 0.75f, 0.625f, 0.75f);
                super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
            }
        }
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        float f = 0.25f;
        switch (BlockPistonExtension._a(n4)) {
            case 0: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                break;
            }
            case 1: {
                this.setBlockBounds(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 2: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                break;
            }
            case 5: {
                this.setBlockBounds(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        int n5 = BlockPistonExtension._a(world.getBlockMetadata(n, n2, n3));
        int n6 = world.getBlockId(n - owak._b[n5], n2 - owak._c[n5], n3 - owak._d[n5]);
        if (n6 != Block.pistonBase.blockID && n6 != Block.pistonStickyBase.blockID) {
            world.setBlockToAir(n, n2, n3);
        } else {
            Block.blocksList[n6].onNeighborBlockChange(world, n - owak._b[n5], n2 - owak._c[n5], n3 - owak._d[n5], n4);
        }
    }

    public static int _a(int n) {
        return n & 7;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        if ((n4 & 8) != 0) {
            return Block.pistonStickyBase.blockID;
        }
        return Block.pistonBase.blockID;
    }
}

