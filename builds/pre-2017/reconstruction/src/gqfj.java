/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class gqfj
extends Block {
    public gqfj(int n) {
        super(n, Material._p);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        float f = 0.125f;
        return AxisAlignedBB._a()._a(n, n2, n3, n + 1, (float)(n2 + 1) - f, n3 + 1);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        entity.motionX *= 0.4;
        entity.motionZ *= 0.4;
    }
}

