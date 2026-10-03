/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public class BlockGrass
extends Block {
    @SideOnly(value=Side.CLIENT)
    public Icon _a;
    @SideOnly(value=Side.CLIENT)
    public Icon _b;
    @SideOnly(value=Side.CLIENT)
    public Icon _c;

    public BlockGrass(int n) {
        super(n, Material._b);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n == 1 ? this._a : (n == 0 ? Block.dirt.getBlockTextureFromSide(n) : this.blockIcon);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        GloomyHooks.updateTick(this, world, n, n2, n3, random);
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.dirt.idDropped(0, random, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this._a;
        }
        if (n4 == 0) {
            return Block.dirt.getBlockTextureFromSide(n4);
        }
        Material material = iBlockAccess.getBlockMaterial(n, n2 + 1, n3);
        return material != Material._x && material != Material._y ? this.blockIcon : this._b;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        BlockRendererList.onRegisterIconsHook(this, iconRegister);
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
        this._b = iconRegister._b(this.getTextureName() + "_side_snowed");
        this._c = iconRegister._b(this.getTextureName() + "_side_overlay");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBlockColor() {
        double d = 0.5;
        double d2 = 1.0;
        return gapq._a(d, d2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderColor(int n) {
        return this.getBlockColor();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int n7 = iBlockAccess.getBiomeGenForCoords(n + j, n3 + i)._l();
                n4 += (n7 & 0xFF0000) >> 16;
                n5 += (n7 & 0xFF00) >> 8;
                n6 += n7 & 0xFF;
            }
        }
        return (n4 / 9 & 0xFF) << 16 | (n5 / 9 & 0xFF) << 8 | n6 / 9 & 0xFF;
    }

    @SideOnly(value=Side.CLIENT)
    public static Icon _a() {
        return Block.grass._c;
    }
}

