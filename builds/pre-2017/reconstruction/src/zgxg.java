/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class zgxg
extends BlockFlower {
    public zgxg(int n) {
        super(n);
        float f = 0.5f;
        float f2 = 0.015625f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public int getRenderType() {
        return 23;
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        if (entity == null || !(entity instanceof EntityBoat)) {
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return AxisAlignedBB._a()._a((double)n + this.minX, (double)n2 + this.minY, (double)n3 + this.minZ, (double)n + this.maxX, (double)n2 + this.maxY, (double)n3 + this.maxZ);
    }

    @Override
    public int getBlockColor() {
        return 2129968;
    }

    @Override
    public int getRenderColor(int n) {
        return 2129968;
    }

    @Override
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 2129968;
    }

    @Override
    public boolean _a(int n) {
        return n == Block.waterStill.blockID;
    }

    @Override
    public boolean canBlockStay(World world, int n, int n2, int n3) {
        if (n2 < 0 || n2 >= 256) {
            return false;
        }
        return world.getBlockMaterial(n, n2 - 1, n3) == Material._h && world.getBlockMetadata(n, n2 - 1, n3) == 0;
    }
}

