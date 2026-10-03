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
                    if (i == 0 && j == 0 && k == 0 || this.field_70331_k.func_72798_a(this.field_70329_l + i, this.field_70330_m + j, this.field_70327_n + k) != 0) continue;
                    this.field_70331_k.func_94575_c(this.field_70329_l + i, this.field_70330_m + j, this.field_70327_n + k, AnomalyMod._N.field_71990_ca);
                }
            }
        }
    }
}

