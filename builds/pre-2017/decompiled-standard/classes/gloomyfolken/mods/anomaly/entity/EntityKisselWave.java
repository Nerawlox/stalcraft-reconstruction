/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly.entity;

import gloomyfolken.mods.anomaly.AnomalyMod;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class EntityKisselWave
extends Entity {
    public float size;
    public float prevSize;
    public float alpha;
    private double localX;
    private double localY;
    private double localZ;
    private boolean canExpand = true;
    private boolean isKisselAtMinusX;
    private boolean isKisselAtPlusX;
    private boolean isKisselAtMinusZ;
    private boolean isKisselAtPlusZ;
    private static final int BLOCK_ID = AnomalyMod._M.field_71990_ca;

    public EntityKisselWave(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntityKisselWave(ozlu ozlu2, double d, double d2, double d3) {
        this(ozlu2);
        this.func_70107_b(d, d2, d3);
        int n = sajh._c(d);
        int n2 = sajh._c(d2);
        int n3 = sajh._c(d3);
        this.localX = d - (double)n;
        this.localY = d2 - (double)n2;
        this.localZ = d3 - (double)n3;
        this.isKisselAtMinusX = ozlu2.func_72798_a(n - 1, n2, n3) == BLOCK_ID;
        this.isKisselAtPlusX = ozlu2.func_72798_a(n + 1, n2, n3) == BLOCK_ID;
        this.isKisselAtMinusZ = ozlu2.func_72798_a(n, n2, n3 - 1) == BLOCK_ID;
        this.isKisselAtPlusZ = ozlu2.func_72798_a(n, n2, n3 + 1) == BLOCK_ID;
        this.alpha = 1.0f;
    }

    @Override
    public void func_70071_h_() {
        this.prevSize = this.size;
        if (this.canExpand) {
            boolean bl = false;
            float f = (this.size + 0.035f) / 2.0f;
            if (!this.isKisselAtMinusX && this.localX - (double)f < 0.0) {
                bl = true;
            }
            if (!this.isKisselAtPlusX && this.localX + (double)f > 1.0) {
                bl = true;
            }
            if (!this.isKisselAtMinusZ && this.localZ - (double)f < 0.0) {
                bl = true;
            }
            if (!this.isKisselAtPlusZ && this.localZ + (double)f > 1.0) {
                bl = true;
            }
            if (!bl) {
                this.size += 0.07f;
            } else {
                this.canExpand = false;
            }
        }
        if (this.field_70173_aa >= 5) {
            this.alpha = (float)((double)this.alpha * 0.85);
            this.alpha = (float)((double)this.alpha - 0.02);
        }
        if (this.field_70173_aa > 40) {
            this.func_70106_y();
        }
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        return n == 2;
    }

    @Override
    protected void func_70088_a() {
    }

    @Override
    protected void func_70037_a(qoac qoac2) {
    }

    @Override
    protected void func_70014_b(qoac qoac2) {
    }
}

