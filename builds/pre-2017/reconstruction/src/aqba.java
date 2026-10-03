/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.tileentity.TileEntity;

public class aqba
extends TileEntity {
    @Override
    public void updateEntity() {
        if (this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L) {
            this.blockType = this.getBlockType();
            if (this.blockType != null && this.blockType instanceof BlockDaylightDetector) {
                ((BlockDaylightDetector)this.blockType)._a(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
    }
}

