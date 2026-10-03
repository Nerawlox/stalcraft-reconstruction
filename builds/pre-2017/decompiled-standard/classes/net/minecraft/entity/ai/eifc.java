/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.passive.EntityTameable;

public class eifc
extends pibk {
    public EntityTameable _f;

    public eifc(EntityTameable entityTameable, Class clazz, int n, boolean bl) {
        super(entityTameable, clazz, n, bl);
        this._f = entityTameable;
    }

    @Override
    public boolean func_75250_a() {
        return !this._f.func_70909_n() && super.func_75250_a();
    }
}

