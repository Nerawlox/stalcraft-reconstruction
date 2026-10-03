/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockContainer
extends Block
implements stgn {
    public BlockContainer(int n, Material material) {
        super(n, material);
        this.isBlockContainer = true;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        super.breakBlock(world, n, n2, n3, n4, n5);
        world.removeBlockTileEntity(n, n2, n3);
    }

    @Override
    public boolean onBlockEventReceived(World world, int n, int n2, int n3, int n4, int n5) {
        super.onBlockEventReceived(world, n, n2, n3, n4, n5);
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity != null) {
            return tileEntity.receiveClientEvent(n4, n5);
        }
        return false;
    }
}

