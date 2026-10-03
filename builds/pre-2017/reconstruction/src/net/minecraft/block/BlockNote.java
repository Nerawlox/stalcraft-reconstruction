/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockNote
extends BlockContainer {
    public BlockNote(int n) {
        super(n, Material._d);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        boolean bl = world.isBlockIndirectlyGettingPowered(n, n2, n3);
        tgvf tgvf2 = (tgvf)world.getBlockTileEntity(n, n2, n3);
        if (tgvf2 != null && tgvf2._b != bl) {
            if (bl) {
                tgvf2._a(world, n, n2, n3);
            }
            tgvf2._b = bl;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        tgvf tgvf2 = (tgvf)world.getBlockTileEntity(n, n2, n3);
        if (tgvf2 != null) {
            tgvf2._a();
            tgvf2._a(world, n, n2, n3);
        }
        return true;
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (world.isRemote) {
            return;
        }
        tgvf tgvf2 = (tgvf)world.getBlockTileEntity(n, n2, n3);
        if (tgvf2 != null) {
            tgvf2._a(world, n, n2, n3);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new tgvf();
    }

    @Override
    public boolean onBlockEventReceived(World world, int n, int n2, int n3, int n4, int n5) {
        float f = (float)Math.pow(2.0, (double)(n5 - 12) / 12.0);
        String string = "harp";
        if (n4 == 1) {
            string = "bd";
        }
        if (n4 == 2) {
            string = "snare";
        }
        if (n4 == 3) {
            string = "hat";
        }
        if (n4 == 4) {
            string = "bassattack";
        }
        world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "note." + string, 3.0f, f);
        world.spawnParticle("note", (double)n + 0.5, (double)n2 + 1.2, (double)n3 + 0.5, (double)n5 / 24.0, 0.0, 0.0);
        return true;
    }
}

