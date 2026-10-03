/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;

public class jhad
extends yckl {
    public jhad(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:electra", 0.07f);
        GloomyCore.instance.airBlocks.add(this.field_71990_ca);
        this.func_71864_b("electra");
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new wnhj();
    }

    @Override
    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        return 10;
    }
}

