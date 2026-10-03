/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.eidj;

public abstract class pisu
extends royz {
    @Override
    public void validate() {
        super.validate();
        if (!this.worldObj.isRemote) {
            eidj._a.add(this);
        }
    }

    public abstract void _g();
}

