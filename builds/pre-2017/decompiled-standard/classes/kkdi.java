/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;

public class kkdi
extends kkdx {
    public kkdi(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:blackhole", 0.01f);
        GloomyCore.instance.airBlocks.add(this.field_71990_ca);
        this.func_71864_b("hole");
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new mqkr();
    }
}

