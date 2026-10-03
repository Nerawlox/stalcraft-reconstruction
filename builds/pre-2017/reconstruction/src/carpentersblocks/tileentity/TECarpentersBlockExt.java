/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.tileentity;

import carpentersblocks.block.BlockCarpentersDaylightSensor;
import carpentersblocks.tileentity.TECarpentersBlock;

public class TECarpentersBlockExt
extends TECarpentersBlock {
    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void updateEntity() {
        if (this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L) {
            this.blockType = this.getBlockType();
            if (this.blockType != null && this.blockType instanceof BlockCarpentersDaylightSensor) {
                ((BlockCarpentersDaylightSensor)this.getBlockType()).updateLightLevel(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
    }
}

