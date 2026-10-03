/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.util.sajh;

public class piev
extends qokq {
    public final /* synthetic */ EntityMinecartMobSpawner _a;

    public piev(EntityMinecartMobSpawner entityMinecartMobSpawner) {
        this._a = entityMinecartMobSpawner;
    }

    @Override
    public void _a(int n) {
        this._a.field_70170_p.func_72960_a(this._a, (byte)n);
    }

    @Override
    public ozlu _a() {
        return this._a.field_70170_p;
    }

    @Override
    public int _b() {
        return sajh._c(this._a.field_70165_t);
    }

    @Override
    public int _c() {
        return sajh._c(this._a.field_70163_u);
    }

    @Override
    public int _d() {
        return sajh._c(this._a.field_70161_v);
    }
}

