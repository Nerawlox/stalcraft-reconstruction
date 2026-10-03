/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.zwat;

public class tdpx
extends zwat {
    public EntityLiving _a;

    public tdpx(EntityLiving entityLiving) {
        this._a = entityLiving;
        this.func_75248_a(4);
        entityLiving.func_70661_as()._e(true);
    }

    @Override
    public boolean func_75250_a() {
        return this._a.func_70090_H() || this._a.func_70058_J();
    }

    @Override
    public void func_75246_d() {
        if (this._a.func_70681_au().nextFloat() < 0.8f) {
            this._a.func_70683_ar()._a();
        }
    }
}

