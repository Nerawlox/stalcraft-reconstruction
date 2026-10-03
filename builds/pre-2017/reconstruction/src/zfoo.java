/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.AnomalyMod;

public abstract class zfoo
extends pisu {
    @Override
    public void _g() {
        for (int i = 1; i <= this._a(); ++i) {
            if (this.worldObj.getBlockId(this.xCoord, this.yCoord + i, this.zCoord) != 0) continue;
            this.worldObj.setBlock(this.xCoord, this.yCoord + i, this.zCoord, AnomalyMod._O.blockID);
        }
    }

    public abstract int _a();
}

