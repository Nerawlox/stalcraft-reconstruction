/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockFlower
extends Block
implements IPlantable {
    public BlockFlower(int n, Material material) {
        super(n, material);
        this.setTickRandomly(true);
        float f = 0.2f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public BlockFlower(int n) {
        this(n, Material._k);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return super.canPlaceBlockAt(world, n, n2, n3) && this.canBlockStay(world, n, n2, n3);
    }

    public boolean _a(int n) {
        return n == Block.grass.blockID || n == Block.dirt.blockID || n == Block.tilledField.blockID;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        super.onNeighborBlockChange(world, n, n2, n3, n4);
        this._c(world, n, n2, n3);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        this._c(world, n, n2, n3);
    }

    public final void _c(World world, int n, int n2, int n3) {
        if (!this.canBlockStay(world, n, n2, n3)) {
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlock(n, n2, n3, 0, 0, 2);
        }
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        GloomyHooks.canBlockStay(this, world, n, n2, n3);
        return true;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
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
    public int getRenderType() {
        int n = GloomyHooks.getRenderType(this);
        return n;
    }

    @Override
    public EnumPlantType getPlantType(World world, int n, int n2, int n3) {
        if (this.blockID == BlockFlower.crops.blockID) {
            return EnumPlantType.Crop;
        }
        if (this.blockID == BlockFlower.deadBush.blockID) {
            return EnumPlantType.Desert;
        }
        if (this.blockID == BlockFlower.waterlily.blockID) {
            return EnumPlantType.Water;
        }
        if (this.blockID == BlockFlower.mushroomRed.blockID) {
            return EnumPlantType.Cave;
        }
        if (this.blockID == BlockFlower.mushroomBrown.blockID) {
            return EnumPlantType.Cave;
        }
        if (this.blockID == BlockFlower.netherStalk.blockID) {
            return EnumPlantType.Nether;
        }
        if (this.blockID == BlockFlower.sapling.blockID) {
            return EnumPlantType.Plains;
        }
        if (this.blockID == BlockFlower.melonStem.blockID) {
            return EnumPlantType.Crop;
        }
        if (this.blockID == BlockFlower.pumpkinStem.blockID) {
            return EnumPlantType.Crop;
        }
        if (this.blockID == BlockFlower.tallGrass.blockID) {
            return EnumPlantType.Plains;
        }
        return EnumPlantType.Plains;
    }

    @Override
    public int getPlantID(World world, int n, int n2, int n3) {
        return this.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int n, int n2, int n3) {
        return world.getBlockMetadata(n, n2, n3);
    }
}

