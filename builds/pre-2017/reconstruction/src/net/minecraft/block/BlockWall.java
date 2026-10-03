/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWall
extends Block {
    public static final String[] _a = new String[]{"normal", "mossy"};

    public BlockWall(int n, Block block) {
        super(n, block.blockMaterial);
        this.setHardness(block.blockHardness);
        this.setResistance(block.blockResistance / 3.0f);
        this.setStepSound(block.stepSound);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n2 == 1) {
            return Block.cobblestoneMossy.getBlockTextureFromSide(n);
        }
        return Block.cobblestone.getBlockTextureFromSide(n);
    }

    @Override
    public int getRenderType() {
        return 32;
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
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        boolean bl = this._a(iBlockAccess, n, n2, n3 - 1);
        boolean bl2 = this._a(iBlockAccess, n, n2, n3 + 1);
        boolean bl3 = this._a(iBlockAccess, n - 1, n2, n3);
        boolean bl4 = this._a(iBlockAccess, n + 1, n2, n3);
        float f = 0.25f;
        float f2 = 0.75f;
        float f3 = 0.25f;
        float f4 = 0.75f;
        float f5 = 1.0f;
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
        if (bl && bl2 && !bl3 && !bl4) {
            f5 = 0.8125f;
            f = 0.3125f;
            f2 = 0.6875f;
        } else if (!bl && !bl2 && bl3 && bl4) {
            f5 = 0.8125f;
            f3 = 0.3125f;
            f4 = 0.6875f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, f5, f4);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        this.maxY = 1.5;
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
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

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        list2.add(new ItemStack(n, 1, 0));
        list2.add(new ItemStack(n, 1, 1));
    }

    @Override
    public int damageDropped(int n) {
        return n;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            return super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
        }
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
    }
}

