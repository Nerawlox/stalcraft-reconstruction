/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.world.World;

public class BlockCommandBlock
extends BlockContainer {
    public BlockCommandBlock(int n) {
        super(n, Material._f);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityCommandBlock();
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            boolean bl;
            boolean bl2 = world.isBlockIndirectlyGettingPowered(n, n2, n3);
            int n5 = world.getBlockMetadata(n, n2, n3);
            boolean bl3 = bl = (n5 & 1) != 0;
            if (bl2 && !bl) {
                world.func_72921_c(n, n2, n3, n5 | 1, 4);
                world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
            } else if (!bl2 && bl) {
                world.func_72921_c(n, n2, n3, n5 & 0xFFFFFFFE, 4);
            }
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity != null && tileEntity instanceof TileEntityCommandBlock) {
            TileEntityCommandBlock tileEntityCommandBlock = (TileEntityCommandBlock)tileEntity;
            tileEntityCommandBlock._a(tileEntityCommandBlock._a(world));
            world.func_96440_m(n, n2, n3, this.blockID);
        }
    }

    @Override
    public int tickRate(World world) {
        return 1;
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        TileEntityCommandBlock tileEntityCommandBlock = (TileEntityCommandBlock)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityCommandBlock != null) {
            entityPlayer.displayGUIEditSign(tileEntityCommandBlock);
        }
        return true;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int n, int n2, int n3, int n4) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity != null && tileEntity instanceof TileEntityCommandBlock) {
            return ((TileEntityCommandBlock)tileEntity)._b();
        }
        return 0;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntityCommandBlock tileEntityCommandBlock = (TileEntityCommandBlock)world.getBlockTileEntity(n, n2, n3);
        if (itemStack._u()) {
            tileEntityCommandBlock._b(itemStack._s());
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }
}

