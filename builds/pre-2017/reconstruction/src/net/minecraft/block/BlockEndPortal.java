/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEndPortal
extends BlockContainer {
    public static boolean _a;

    public BlockEndPortal(int n, Material material) {
        super(n, material);
        this.setLightValue(1.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new zziy();
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        float f = 0.0625f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (n4 != 0) {
            return false;
        }
        return super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
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
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        if (entity.ridingEntity == null && entity.riddenByEntity == null && !world.isRemote) {
            entity.travelToDimension(1);
        }
    }

    @Override
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        double d = (float)n + random.nextFloat();
        double d2 = (float)n2 + 0.8f;
        double d3 = (float)n3 + random.nextFloat();
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        world.spawnParticle("smoke", d, d2, d3, d4, d5, d6);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        if (_a) {
            return;
        }
        if (world.provider._i != 0) {
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return 0;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("portal");
    }
}

