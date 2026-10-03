/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;

public class piet {
    public EntityLiving _a;
    public boolean _b;

    public piet(EntityLiving entityLiving) {
        this._a = entityLiving;
    }

    public void _a() {
        this._b = true;
    }

    public void _b() {
        this._a.func_70637_d(this._b);
        this._b = false;
    }
}

