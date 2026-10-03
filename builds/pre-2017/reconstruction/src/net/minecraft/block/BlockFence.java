/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFence
extends Block {
    public final String _a;

    public BlockFence(int n, String string, Material material) {
        super(n, material);
        this._a = string;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        boolean bl = this._a(world, n, n2, n3 - 1);
        boolean bl2 = this._a(world, n, n2, n3 + 1);
        boolean bl3 = this._a(world, n - 1, n2, n3);
        boolean bl4 = this._a(world, n + 1, n2, n3);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl || bl2) {
            this.setBlockBounds(f, 0.0f, f3, f2, 1.5f, f4);
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        f3 = 0.375f;
        f4 = 0.625f;
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        if (bl3 || bl4 || !bl && !bl2) {
            this.setBlockBounds(f, 0.0f, f3, f2, 1.5f, f4);
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        boolean bl = this._a(iBlockAccess, n, n2, n3 - 1);
        boolean bl2 = this._a(iBlockAccess, n, n2, n3 + 1);
        boolean bl3 = this._a(iBlockAccess, n - 1, n2, n3);
        boolean bl4 = this._a(iBlockAccess, n + 1, n2, n3);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
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
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return false;
    }

    @Override
    public int getRenderType() {
        return 11;
    }

    public boolean _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockId(n, n2, n3);
        if (n4 == this.blockID || n4 == Block.fenceGate.blockID) {
            return true;
        }
        Block block = Block.blocksList[n4];
        if (block != null && block.blockMaterial._k() && block.renderAsNormalBlock()) {
            return block.blockMaterial != Material._B;
        }
        return false;
    }

    public static boolean _a(int n) {
        return n == Block.fence.blockID || n == Block.netherFence.blockID;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this._a);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        return bsut._a(entityPlayer, world, n, n2, n3);
    }
}

