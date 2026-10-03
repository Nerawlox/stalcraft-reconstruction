/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;

public class EntityCrit2FX
extends EntityFX {
    public Entity field_70557_a;
    public int field_70560_aq;
    public int field_70559_ar;
    public String field_70558_as;

    public EntityCrit2FX(ozlu ozlu2, Entity entity) {
        this(ozlu2, entity, "crit");
    }

    public EntityCrit2FX(ozlu ozlu2, Entity entity, String string) {
        super(ozlu2, entity.field_70165_t, entity.field_70121_D._c + (double)(entity.field_70131_O / 2.0f), entity.field_70161_v, entity.field_70159_w, entity.field_70181_x, entity.field_70179_y);
        this.field_70557_a = entity;
        this.field_70559_ar = 3;
        this.field_70558_as = string;
        this.func_70071_h_();
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override
    public void func_70071_h_() {
        for (int i = 0; i < 16; ++i) {
            double d;
            double d2;
            double d3 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
            if (d3 * d3 + (d2 = (double)(this.field_70146_Z.nextFloat() * 2.0f - 1.0f)) * d2 + (d = (double)(this.field_70146_Z.nextFloat() * 2.0f - 1.0f)) * d > 1.0) continue;
            double d4 = this.field_70557_a.field_70165_t + d3 * (double)this.field_70557_a.field_70130_N / 4.0;
            double d5 = this.field_70557_a.field_70121_D._c + (double)(this.field_70557_a.field_70131_O / 2.0f) + d2 * (double)this.field_70557_a.field_70131_O / 4.0;
            double d6 = this.field_70557_a.field_70161_v + d * (double)this.field_70557_a.field_70130_N / 4.0;
            this.field_70170_p.func_72869_a(this.field_70558_as, d4, d5, d6, d3, d2 + 0.2, d);
        }
        ++this.field_70560_aq;
        if (this.field_70560_aq >= this.field_70559_ar) {
            this.func_70106_y();
        }
    }

    @Override
    public int func_70537_b() {
        return 3;
    }
}

