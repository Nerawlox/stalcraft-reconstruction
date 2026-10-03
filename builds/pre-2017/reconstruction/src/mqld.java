/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.AnomalyMod;

public abstract class mqld
extends pisu {
    @Override
    public void _g() {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                for (int k = -1; k < 2; ++k) {
                    if (i == 0 && j == 0 && k == 0 || this.worldObj.getBlockId(this.xCoord + i, this.yCoord + j, this.zCoord + k) != 0) continue;
                    this.worldObj.setBlock(this.xCoord + i, this.yCoord + j, this.zCoord + k, AnomalyMod._N.blockID);
                }
            }
        }
    }
}

