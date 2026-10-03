/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockWorkbench
extends Block {
    public Icon _a;
    public Icon _b;

    public BlockWorkbench(int n) {
        super(n, Material._d);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        if (n == 0) {
            return Block.planks.getBlockTextureFromSide(n);
        }
        if (n == 2 || n == 4) {
            return this._b;
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
        this._b = iconRegister._b(this.getTextureName() + "_front");
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        entityPlayer.displayGUIWorkbench(n, n2, n3);
        return true;
    }
}

