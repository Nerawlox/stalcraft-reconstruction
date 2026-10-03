/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ezfa;
import net.minecraft.util.jxtc;

public class EntityDragonPart
extends Entity {
    public final ezfa field_70259_a;
    public final String field_70258_b;

    public EntityDragonPart(ezfa ezfa2, String string, float f, float f2) {
        super(ezfa2.func_82194_d());
        this.func_70105_a(f, f2);
        this.field_70259_a = ezfa2;
        this.field_70258_b = string;
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public void func_70037_a(qoac qoac2) {
    }

    @Override
    public void func_70014_b(qoac qoac2) {
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        return this.field_70259_a.func_70965_a(this, jxtc2, f);
    }

    @Override
    public boolean func_70028_i(Entity entity) {
        return this == entity || this.field_70259_a == entity;
    }
}

