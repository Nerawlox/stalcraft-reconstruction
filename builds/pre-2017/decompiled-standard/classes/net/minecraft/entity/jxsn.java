/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;

public enum jxsn {
    _a(ezey.class, 70, tflj._a, false, false),
    _b(EntityAnimal.class, 10, tflj._a, true, true),
    _c(EntityAmbientCreature.class, 15, tflj._a, true, false),
    _d(EntityWaterMob.class, 5, tflj._h, true, false);

    public final Class _e;
    public final int _f;
    public final tflj _g;
    public final boolean _h;
    public final boolean _i;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public jxsn(tflj tflj2, boolean bl, boolean bl2) {
        void var7_5;
        void var6_4;
        this._e = tflj2;
        this._f = bl ? 1 : 0;
        this._g = (tflj)bl2;
        this._h = var6_4;
        this._i = var7_5;
    }

    public Class _a() {
        return this._e;
    }

    public int _b() {
        return this._f;
    }

    public tflj _c() {
        return this._g;
    }

    public boolean _d() {
        return this._h;
    }

    public boolean _e() {
        return this._i;
    }
}

