/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class uhov
extends TileEntity {
    @Override
    @ezey(_a={eidj.CLIENT})
    public double getMaxRenderDistanceSquared() {
        Block block = this.getBlockType();
        return Math.min(fmea._a._a(block), (float)(ClientProxy.decorblockRenderDistance.value * ClientProxy.decorblockRenderDistance.value));
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void validate() {
        super.validate();
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public AxisAlignedBB getRenderBoundingBox() {
        Block block = this.getBlockType();
        if (block == null) {
            return TileEntity.INFINITE_EXTENT_AABB;
        }
        return AxisAlignedBB._a()._a((double)this.xCoord + block.minX - 4.0, (double)this.yCoord + block.minY - 4.0, (double)this.zCoord + block.minZ - 4.0, (double)this.xCoord + block.maxX + 5.0, (double)this.yCoord + block.maxY + 5.0, (double)this.zCoord + block.maxZ + 5.0);
    }
}

