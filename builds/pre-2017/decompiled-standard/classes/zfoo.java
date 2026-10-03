/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.AnomalyMod;

public abstract class zfoo
extends pisu {
    @Override
    public void _g() {
        for (int i = 1; i <= this._a(); ++i) {
            if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m + i, this.field_70327_n) != 0) continue;
            this.field_70331_k.func_94575_c(this.field_70329_l, this.field_70330_m + i, this.field_70327_n, AnomalyMod._O.field_71990_ca);
        }
    }

    public abstract int _a();
}

