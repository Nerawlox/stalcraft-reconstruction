/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.block;

public class TilePreset
extends hurg {
    public String presetName = "";
    public String targetRegion = "";

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this.presetName = qoac2._j("PresetName");
        this.targetRegion = qoac2._j("TargetRegion");
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("PresetName", this.presetName);
        qoac2._a("TargetRegion", this.targetRegion);
    }
}

