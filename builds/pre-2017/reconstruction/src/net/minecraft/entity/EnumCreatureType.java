/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;

public enum EnumCreatureType {
    _a(ezey.class, 70, Material._a, false, false),
    _b(EntityAnimal.class, 10, Material._a, true, true),
    _c(EntityAmbientCreature.class, 15, Material._a, true, false),
    _d(EntityWaterMob.class, 5, Material._h, true, false);

    public final Class _e;
    public final int _f;
    public final Material _g;
    public final boolean _h;
    public final boolean _i;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public EnumCreatureType(Material material, boolean bl, boolean bl2) {
        void var7_5;
        void var6_4;
        this._e = material;
        this._f = bl ? 1 : 0;
        this._g = (Material)bl2;
        this._h = var6_4;
        this._i = var7_5;
    }

    public Class _a() {
        return this._e;
    }

    public int _b() {
        return this._f;
    }

    public Material _c() {
        return this._g;
    }

    public boolean _d() {
        return this._h;
    }

    public boolean _e() {
        return this._i;
    }
}

