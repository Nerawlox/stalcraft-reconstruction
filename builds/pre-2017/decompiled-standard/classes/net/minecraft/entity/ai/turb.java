/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.zwat;

public class turb
extends zwat {
    public EntityCreature _a;

    public turb(EntityCreature entityCreature) {
        this._a = entityCreature;
    }

    @Override
    public boolean func_75250_a() {
        return this._a.field_70170_p.func_72935_r();
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._d(true);
    }

    @Override
    public void func_75251_c() {
        this._a.func_70661_as()._d(false);
    }
}

