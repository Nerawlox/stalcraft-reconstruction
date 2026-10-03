/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDaylightDetector
extends BlockContainer {
    public Icon[] _a = new Icon[2];

    public BlockDaylightDetector(int n) {
        super(n, Material._d);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return iBlockAccess.getBlockMetadata(n, n2, n3);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
    }

    public void _a(World world, int n, int n2, int n3) {
        if (world.provider._g) {
            return;
        }
        int n4 = world.getBlockMetadata(n, n2, n3);
        int n5 = world.getSavedLightValue(EnumSkyBlock._a, n, n2, n3) - world.skylightSubtracted;
        float f = world.getCelestialAngleRadians(1.0f);
        f = f < (float)Math.PI ? (f += (0.0f - f) * 0.2f) : (f += ((float)Math.PI * 2 - f) * 0.2f);
        n5 = Math.round((float)n5 * sajh._b(f));
        if (n5 < 0) {
            n5 = 0;
        }
        if (n5 > 15) {
            n5 = 15;
        }
        if (n4 != n5) {
            world.func_72921_c(n, n2, n3, n5, 3);
        }
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
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new aqba();
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._a[0];
        }
        return this._a[1];
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._a[0] = iconRegister._b(this.getTextureName() + "_top");
        this._a[1] = iconRegister._b(this.getTextureName() + "_side");
    }
}

