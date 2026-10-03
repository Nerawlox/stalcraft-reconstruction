/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.block.BlockStalkerSlope;
import carpentersblocks.data.Slope;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BlockStalkerSlopeDouble
extends BlockStalkerSlope {
    public BlockStalkerSlopeDouble(int n, Block block) {
        super(n, block);
        this.setUnlocalizedName("BlockSlopeDouble_" + block.unlocalizedName);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        this.getCoverBlock().addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list, entity);
        int n4 = world.getBlockMetadata(n, n2, n3);
        Slope slope = BlockStalkerSlopeDouble.getSlopeFromMeta(n4);
        this.addSlopeCollision(slope, n, n2 + 1, n3, list);
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        return this.getCoverBlock().collisionRayTrace(world, n, n2, n3, vec3, vec32);
    }

    @Override
    public boolean shouldRenderBase() {
        return true;
    }
}

